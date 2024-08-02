import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

data class KotlinColor(
    val red: Double = 0.0,
    val green: Double = 0.0,
    val blue: Double = 0.0,
    val alpha: Double = 1.0
)

fun KotlinColor.toColor() = Color(
    red = this.red.toFloat(),
    green = this.green.toFloat(),
    blue = this.blue.toFloat(),
    alpha = this.alpha.toFloat()
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
    val secondary: KotlinColor,
    val onSecondary: KotlinColor,
    val secondaryContainer: KotlinColor,
    val onSecondaryContainer: KotlinColor,
    val tertiary: KotlinColor,
    val onTertiary: KotlinColor,
    val tertiaryContainer: KotlinColor,
    val onTertiaryContainer: KotlinColor,
    val surface: KotlinColor,
    val surfaceDim : KotlinColor,
    val surfaceBright: KotlinColor,
    val surfaceContainer: KotlinColor,
    val surfaceContainerHigh: KotlinColor,
    val surfaceContainerHighest: KotlinColor,
    val surfaceContainerLow: KotlinColor,
    val surfaceContainerLowest: KotlinColor,
    val onSurface: KotlinColor,
    val surfaceVariant: KotlinColor,
    val onSurfaceVariant: KotlinColor,
    val outline: KotlinColor,
    val outlineVariant: KotlinColor,
    val error: KotlinColor,
    val onError: KotlinColor,
    val errorContainer: KotlinColor,
    val onErrorContainer: KotlinColor,
    val scrim: KotlinColor,
    val inverseSurface: KotlinColor,
    val inverseOnSurface: KotlinColor,
    val inversePrimary: KotlinColor,
)

fun ColorScheme.toKotlinColorScheme() = KotlinColorScheme(
    primary = this.primary.toKotlinColor(),
    onPrimary = this.onPrimary.toKotlinColor(),
    primaryContainer = this.primaryContainer.toKotlinColor(),
    onPrimaryContainer = this.onPrimaryContainer.toKotlinColor(),
    secondary = this.secondary.toKotlinColor(),
    onSecondary = this.onSecondary.toKotlinColor(),
    secondaryContainer = this.secondaryContainer.toKotlinColor(),
    onSecondaryContainer = this.onSecondaryContainer.toKotlinColor(),
    tertiary = this.tertiary.toKotlinColor(),
    onTertiary = this.onTertiary.toKotlinColor(),
    tertiaryContainer = this.tertiaryContainer.toKotlinColor(),
    onTertiaryContainer = this.onTertiaryContainer.toKotlinColor(),
    surface = this.surface.toKotlinColor(),
    onSurface = this.onSurface.toKotlinColor(),
    surfaceDim = this.surfaceDim.toKotlinColor(),
    surfaceBright = this.surfaceBright.toKotlinColor(),
    surfaceContainer = this.surfaceContainer.toKotlinColor(),
    surfaceContainerHigh = this.surfaceContainerHigh.toKotlinColor(),
    surfaceContainerHighest = this.surfaceContainerHighest.toKotlinColor(),
    surfaceContainerLow = this.surfaceContainerLow.toKotlinColor(),
    surfaceContainerLowest = this.surfaceContainerLowest.toKotlinColor(),
    surfaceVariant = this.surfaceVariant.toKotlinColor(),
    onSurfaceVariant = this.onSurfaceVariant.toKotlinColor(),
    outline = this.outline.toKotlinColor(),
    outlineVariant = this.outlineVariant.toKotlinColor(),
    error = this.error.toKotlinColor(),
    onError = this.onError.toKotlinColor(),
    errorContainer = this.errorContainer.toKotlinColor(),
    onErrorContainer = this.onErrorContainer.toKotlinColor(),
    scrim = this.scrim.toKotlinColor(),
    inverseSurface = this.inverseSurface.toKotlinColor(),
    inverseOnSurface = this.inverseOnSurface.toKotlinColor(),
    inversePrimary = this.inversePrimary.toKotlinColor(),
)