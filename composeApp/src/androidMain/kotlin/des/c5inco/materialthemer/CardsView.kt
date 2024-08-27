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
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.materialkolor.PaletteStyle
import des.c5inco.materialthemer.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardsView(
    modifier: Modifier = Modifier,
    activePaletteStyle: PaletteStyle = PaletteStyle.TonalSpot,
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        topBar = {
            SharedTopAppBar(
                title = { Text("$activePaletteStyle cards") },
                scrollBehavior = scrollBehavior
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
private fun CardsViewPreview() {
    AppTheme {
        CardsView()
    }
}