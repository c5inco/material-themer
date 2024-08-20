package des.c5inco.materialthemer.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.materialkolor.DynamicMaterialTheme
import com.materialkolor.PaletteStyle

@Composable
fun AppTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    DynamicMaterialTheme(
        seedColor = Color.Red,
        useDarkTheme = useDarkTheme,
        style = PaletteStyle.TonalSpot
    ) {
        content()
    }
}