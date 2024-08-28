package des.c5inco.materialthemer

import android.content.Context
import android.icu.text.NumberFormat
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.materialkolor.PaletteStyle
import des.c5inco.materialthemer.ui.theme.AppTheme
import kotlin.text.format

data class Card(
    @DrawableRes val icon: Int,
    val title: String,
    val type: CardType,
    val price: Double
)

enum class CardType {
    Devices,
    Displays,
    Accessories
}

fun Double.formatToCurrency(context: Context): String {
    val locale = context.resources.configuration.locales[0]
    val currencyFormatter = NumberFormat.getCurrencyInstance(locale)
    return currencyFormatter.format(this)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardsView(
    modifier: Modifier = Modifier,
    activeSeedColor: Color,
    onSeedColorChange: (Color) -> Unit = { _ ->},
    activePaletteStyle: PaletteStyle = PaletteStyle.TonalSpot,
    onPaletteChange: (PaletteStyle) -> Unit = { _ ->}
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val cards = listOf(
        Card(R.drawable.ic_hmd, "Daydream", CardType.Devices, 99.0),
        Card(R.drawable.ic_hmd, "Cardboard", CardType.Displays, 15.0),
        Card(R.drawable.ic_smartphone, "Pixel 9", CardType.Devices, 999.0),
        Card(R.drawable.ic_watch, "Pixel Watch", CardType.Devices, 799.0),
        Card(R.drawable.ic_headphones, "Pixel Buds Pro 2", CardType.Accessories, 229.0),
        Card(R.drawable.ic_computer, "Chromebook", CardType.Displays, 4999.0),
        Card(R.drawable.ic_tablet, "Pixel C", CardType.Devices, 499.0),
        Card(R.drawable.ic_headphones, "Pixel Buds A-Series", CardType.Accessories, 99.0),
        Card(R.drawable.ic_dns, "Chrome Box", CardType.Displays, 799.0),
        Card(R.drawable.ic_cast, "Google TV", CardType.Devices, 499.0)
    )

    Scaffold(
        topBar = {
            SharedTopAppBar(
                title = { Text("$activePaletteStyle cards") },
                scrollBehavior = scrollBehavior,
                activeSeedColor = activeSeedColor,
                onSeedColorChange = onSeedColorChange,
                activePaletteStyle = activePaletteStyle,
                onPaletteChange = onPaletteChange
            )
        },
        modifier = modifier
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(top = innerPadding.calculateTopPadding())
                .nestedScroll(scrollBehavior.nestedScrollConnection)
        ) {
            items(cards) { card ->
                Card(
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = getOnSurfaceColor(card.type)
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(id = card.icon),
                            contentDescription = null,
                            modifier = Modifier.size(64.dp)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = card.title,
                            style = MaterialTheme.typography.titleMedium,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = card.price.formatToCurrency(LocalContext.current),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun getOnSurfaceColor(type: CardType): Color {
    return when (type) {
        CardType.Devices -> MaterialTheme.colorScheme.primaryContainer
        CardType.Displays -> MaterialTheme.colorScheme.secondaryContainer
        CardType.Accessories -> MaterialTheme.colorScheme.tertiaryContainer
    }
}

@PreviewLightDark
@Composable
private fun CardsViewPreview() {
    AppTheme {
        CardsView(activeSeedColor = seedColors.first())
    }
}