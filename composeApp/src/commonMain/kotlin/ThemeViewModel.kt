import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.materialkolor.PaletteStyle
import com.materialkolor.dynamicColorScheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ThemeViewModel(
    private val isDark: Boolean = false
) : ViewModel() {
    private val _seedColors = listOf(
        Color(0xffB33B15),
        Color(0xff63A002),
        Color(0xff769CDF),
        Color(0xffFFDE3F),
    )
    val activeSeedColor = MutableStateFlow(_seedColors[2])

    private val _paletteStyle = MutableStateFlow(PaletteStyle.TonalSpot)

    fun getDynamicColorScheme(
        seedColor: KotlinColor,
        isDark: Boolean
    ): KotlinColorScheme {
        return dynamicColorScheme(
            seedColor = seedColor.toColor(),
            isDark = isDark,
            isAmoled = false,
            style = _paletteStyle.value
        ).toKotlinColorScheme()
    }

    fun updateSeedColor(index: Int = 0) {
        activeSeedColor.update {
            _seedColors[index]
        }
    }

    fun updateStyle(style: PaletteStyle) {
        _paletteStyle.update { style }
    }
}