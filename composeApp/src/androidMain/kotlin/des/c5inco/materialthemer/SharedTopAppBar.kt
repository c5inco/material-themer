package des.c5inco.materialthemer

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.materialkolor.PaletteStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SharedTopAppBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior,
    activeSeedColor: Color,
    onSeedColorChange: (Color) -> Unit = { _ -> },
    activePaletteStyle: PaletteStyle,
    onPaletteChange: (PaletteStyle) -> Unit = { _ -> },
    title: @Composable () -> Unit,
) {
    var expandMenu by remember { mutableStateOf(false) }

    MediumTopAppBar(
        title = title,
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.ic_hmd),
                    contentDescription = null
                )
            }
        },
        actions = {
            Box {
                IconButton(onClick = { expandMenu = true }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_palette),
                        contentDescription = null
                    )
                }
                DropdownMenu(
                    expanded = expandMenu,
                    onDismissRequest = { expandMenu = false },
                    modifier = Modifier.width(200.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .horizontalScroll(rememberScrollState())
                    ) {
                        Spacer(Modifier.width(8.dp))
                        seedColors.forEach { color ->
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .padding(end = 4.dp)
                                    .clip(CircleShape)
                                    .clickable {
                                        expandMenu = false
                                        onSeedColorChange(color)
                                    }
                                    .size(32.dp)
                                    .then(
                                        if (color == activeSeedColor) {
                                            Modifier.border(
                                                width = 2.dp,
                                                color = MaterialTheme.colorScheme.primary,
                                                shape = CircleShape
                                            )
                                        } else {
                                            Modifier
                                        }
                                    )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(18.dp)
                                        .background(color = color, shape = CircleShape)
                                )
                            }
                        }
                    }
                    PaletteStyle.entries.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(text = item.name) },
                            trailingIcon = {
                                if (item == activePaletteStyle) {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_check),
                                        contentDescription = null
                                    )
                                }
                            },
                            onClick = {
                                onPaletteChange(item)
                                expandMenu = false
                            }
                        )
                    }
                }
            }
        },
        scrollBehavior = scrollBehavior,
        modifier = modifier
    )
}