package des.c5inco.materialthemer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.materialkolor.PaletteStyle
import des.c5inco.materialthemer.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaletteView(
    modifier: Modifier = Modifier,
    activeSeedColor: Color,
    onSeedColorChange: (Color) -> Unit = { _ -> },
    activePaletteStyle: PaletteStyle = PaletteStyle.TonalSpot,
    onPaletteChange: (PaletteStyle) -> Unit = { _ -> },
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        topBar = {
            SharedTopAppBar(
                scrollBehavior = scrollBehavior,
                activeSeedColor = activeSeedColor,
                onSeedColorChange = onSeedColorChange,
                activePaletteStyle = activePaletteStyle,
                onPaletteChange = onPaletteChange,
                title = { Text("$activePaletteStyle palette") },
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Action")
            }
        }
    }
}
@PreviewLightDark
@Composable
private fun PaletteViewPreview() {
    AppTheme {
        PaletteView(
            activeSeedColor = seedColors.first()
        )
    }
}