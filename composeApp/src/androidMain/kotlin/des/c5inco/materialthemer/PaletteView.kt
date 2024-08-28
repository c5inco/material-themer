package des.c5inco.materialthemer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
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
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .padding(top = innerPadding.calculateTopPadding())
                .nestedScroll(scrollBehavior.nestedScrollConnection)
        ) {
            item {
                PairedSwatch(
                    label = "primary",
                    background = MaterialTheme.colorScheme.primary,
                    foreground = MaterialTheme.colorScheme.onPrimary,
                    onLabel = "onPrimary",
                    onBackground = MaterialTheme.colorScheme.onPrimary,
                    onForeground = MaterialTheme.colorScheme.primary
                )
            }
            item {
                Row {
                    PairedSwatch(
                        label = "secondary",
                        background = MaterialTheme.colorScheme.secondary,
                        foreground = MaterialTheme.colorScheme.onSecondary,
                        onLabel = "onSecondary",
                        onBackground = MaterialTheme.colorScheme.onSecondary,
                        onForeground = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    PairedSwatch(
                        label = "tertiary",
                        background = MaterialTheme.colorScheme.tertiary,
                        foreground = MaterialTheme.colorScheme.onTertiary,
                        onLabel = "onTertiary",
                        onBackground = MaterialTheme.colorScheme.onTertiary,
                        onForeground = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            item {
                PairedSwatch(
                    label = "primaryContainer",
                    background = MaterialTheme.colorScheme.primaryContainer,
                    foreground = MaterialTheme.colorScheme.onPrimaryContainer,
                    onLabel = "onPrimaryContainer",
                    onBackground = MaterialTheme.colorScheme.onPrimaryContainer,
                    onForeground = MaterialTheme.colorScheme.primaryContainer
                )
            }
            item {
                Row {
                    PairedSwatch(
                        label = "secondaryContainer",
                        background = MaterialTheme.colorScheme.secondaryContainer,
                        foreground = MaterialTheme.colorScheme.onSecondaryContainer,
                        onLabel = "onSecondaryContainer",
                        onBackground = MaterialTheme.colorScheme.onSecondaryContainer,
                        onForeground = MaterialTheme.colorScheme.secondaryContainer,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    PairedSwatch(
                        label = "tertiaryContainer",
                        background = MaterialTheme.colorScheme.tertiaryContainer,
                        foreground = MaterialTheme.colorScheme.onTertiaryContainer,
                        onLabel = "onTertiaryContainer",
                        onBackground = MaterialTheme.colorScheme.onTertiaryContainer,
                        onForeground = MaterialTheme.colorScheme.tertiaryContainer,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            item {
                Row {
                    PairedSwatch(
                        label = "error",
                        background = MaterialTheme.colorScheme.error,
                        foreground = MaterialTheme.colorScheme.onError,
                        onLabel = "onError",
                        onBackground = MaterialTheme.colorScheme.onError,
                        onForeground = MaterialTheme.colorScheme.error,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    PairedSwatch(
                        label = "errorContainer",
                        background = MaterialTheme.colorScheme.errorContainer,
                        foreground = MaterialTheme.colorScheme.onErrorContainer,
                        onLabel = "onErrorContainer",
                        onBackground = MaterialTheme.colorScheme.onErrorContainer,
                        onForeground = MaterialTheme.colorScheme.errorContainer,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            item {
                Row {
                    Swatch(
                        label = "surfaceDim",
                        background = MaterialTheme.colorScheme.surfaceDim,
                        foreground = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Swatch(
                        label = "surfaceBright",
                        background = MaterialTheme.colorScheme.surfaceBright,
                        foreground = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            item {
                Swatch(
                    label = "surface",
                    background = MaterialTheme.colorScheme.surface,
                    foreground = MaterialTheme.colorScheme.onSurface
                )
            }
            item {
                PairedSwatch(
                    label = "inverseSurface",
                    background = MaterialTheme.colorScheme.inverseSurface,
                    foreground = MaterialTheme.colorScheme.inverseOnSurface,
                    onLabel = "inverseOnSurface",
                    onBackground = MaterialTheme.colorScheme.inverseOnSurface,
                    onForeground = MaterialTheme.colorScheme.inverseSurface
                )
            }
            item {
                Swatch(
                    label = "inversePrimary",
                    background = MaterialTheme.colorScheme.inversePrimary,
                    foreground = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            item {
                Row {
                    Swatch(
                        label = "surfaceContainerLow",
                        background = MaterialTheme.colorScheme.surfaceContainerLow,
                        foreground = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Swatch(
                        label = "surfaceContainerLowest",
                        background = MaterialTheme.colorScheme.surfaceContainerLowest,
                        foreground = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            item {
                Swatch(
                    label = "surfaceContainer",
                    background = MaterialTheme.colorScheme.surfaceContainer,
                    foreground = MaterialTheme.colorScheme.onSurface
                )
            }
            item {
                Row {
                    Swatch(
                        label = "surfaceContainerHigh",
                        background = MaterialTheme.colorScheme.surfaceContainerHigh,
                        foreground = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Swatch(
                        label = "surfaceContainerHighest",
                        background = MaterialTheme.colorScheme.surfaceContainerHighest,
                        foreground = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            item {
                Row {
                    Swatch(
                        label = "outline",
                        background = MaterialTheme.colorScheme.outline,
                        foreground = MaterialTheme.colorScheme.inverseOnSurface,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Swatch(
                        label = "outlineVariant",
                        background = MaterialTheme.colorScheme.outlineVariant,
                        foreground = MaterialTheme.colorScheme.inverseSurface,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
private fun Swatch(
    modifier: Modifier = Modifier,
    label: String,
    background: Color,
    foreground: Color
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(background)
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Text(
            text = label,
            color = foreground,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        )
    }
}

@Composable
private fun PairedSwatch(
    modifier: Modifier = Modifier,
    label: String,
    background: Color,
    foreground: Color,
    onLabel: String,
    onBackground: Color,
    onForeground: Color
) {
    Column(
        modifier = modifier.clip(RoundedCornerShape(24.dp))
    ) {
        Box(
            modifier = Modifier
                .background(background)
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Text(
                text = label,
                color = foreground,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            )
        }
        Row(
            modifier = Modifier.background(onBackground)
        ) {
            Text(
                text = onLabel,
                color = onForeground,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .padding(16.dp)
            )
            Spacer(Modifier.weight(1f))
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