import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color
import org.jetbrains.skia.Surface

data class KotlinColor(
    val red: Double = 0.0,
    val green: Double = 0.0,
    val blue: Double = 0.0,
    val alpha: Double = 1.0
)

fun Color.toKotlinColor() = KotlinColor(
    red = this.red.toDouble(),
    green = this.green.toDouble(),
    blue = this.blue.toDouble(),
    alpha = this.alpha.toDouble()
)

data class KotlinColorScheme(
    val primary: KotlinColor,
    val onPrimary: KotlinColor,
    val primaryContainer: KotlinColor,
    val onPrimaryContainer: KotlinColor,
    val surface: KotlinColor,
    val onSurface: KotlinColor,
)

fun ColorScheme.toKotlinColorScheme() = KotlinColorScheme(
    primary = this.primary.toKotlinColor(),
    onPrimary = this.onPrimary.toKotlinColor(),
    primaryContainer = this.primaryContainer.toKotlinColor(),
    onPrimaryContainer = this.onPrimaryContainer.toKotlinColor(),
    surface = this.surface.toKotlinColor(),
    onSurface = this.onSurface.toKotlinColor()
)