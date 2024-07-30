import androidx.lifecycle.ViewModel
import com.materialkolor.PaletteStyle
import com.materialkolor.dynamicColorScheme

class ThemeViewModel(
    private val isDark: Boolean = false
) : ViewModel() {
    fun getDynamicColorScheme(
        seedColor: KotlinColor,
        paletteStyle: PaletteStyle = PaletteStyle.TonalSpot,
        isDark: Boolean
    ): KotlinColorScheme {
        return dynamicColorScheme(
            seedColor = seedColor.toColor(),
            isDark = isDark,
            isAmoled = false,
            style = paletteStyle,
        ).toKotlinColorScheme()
    }
}