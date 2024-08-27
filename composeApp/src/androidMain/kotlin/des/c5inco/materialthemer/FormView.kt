package des.c5inco.materialthemer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.materialkolor.PaletteStyle
import des.c5inco.materialthemer.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormView(
    modifier: Modifier = Modifier,
    activePaletteStyle: PaletteStyle = PaletteStyle.TonalSpot,
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        topBar = {
            SharedTopAppBar(
                title = { Text("$activePaletteStyle form") },
                scrollBehavior = scrollBehavior
            )
        },
        modifier = modifier
    ) { innerPadding ->
        var text by rememberSaveable { mutableStateOf("") }
        var isSwitchChecked by rememberSaveable { mutableStateOf(true) }

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Search") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(24.dp))

            Text(
                text = "Header text".uppercase(),
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .graphicsLayer {
                    alpha = 0.7f
                }
            )
            Spacer(Modifier.height(8.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                FormRow {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_info),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                    )
                }
                FormRow {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                    )
                }
                FormRow {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_check),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                    )
                }
            }
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Footer",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .graphicsLayer {
                        alpha = 0.7f
                    }
            )

            Spacer(Modifier.height(24.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                FormRow {
                    Row {
                        FilledIconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_remove),
                                contentDescription = null,
                            )
                        }
                        FilledIconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_add),
                                contentDescription = null,
                            )
                        }
                    }
                }
                FormRow {
                    Switch(
                        checked = isSwitchChecked,
                        onCheckedChange = { isSwitchChecked = it },
                    )
                }
            }

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Action")
            }
        }
    }
}

@Composable
private fun FormRow(
    modifier: Modifier = Modifier,
    action: @Composable () -> Unit = {},
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.surfaceContainerLow, shape = MaterialTheme.shapes.medium)
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text("Title")
        action()
    }
}

@PreviewLightDark
@Composable
private fun FormViewPreview() {
    AppTheme {
        FormView()
    }
}