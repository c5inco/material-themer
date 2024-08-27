package des.c5inco.materialthemer

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.materialkolor.PaletteStyle
import des.c5inco.materialthemer.ui.theme.AppTheme

sealed class Screen(
    val route: String,
    val name: String,
    @DrawableRes val resourceId: Int
) {
    object Form : Screen("form", "Form", R.drawable.ic_settings)
    object Cards : Screen("cards", "Cards", R.drawable.ic_card)
    object Palette : Screen("palette", "Palette", R.drawable.ic_stacks)
}

val navigationItems = listOf(
    Screen.Form, Screen.Cards, Screen.Palette
)

@Composable
fun HomeView(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val activePaletteStyle by remember { mutableStateOf(PaletteStyle.TonalSpot) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                navigationItems.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(
                            painter = painterResource(id = screen.resourceId),
                            contentDescription = null)
                        },
                        label = { Text(screen.name) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        },
        modifier = modifier
    ) { innerPadding ->
        // Content of your screen
        NavHost(
            navController = navController,
            startDestination = Screen.Cards.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Form.route) {
                FormView(activePaletteStyle = activePaletteStyle)
            }
            composable(Screen.Cards.route) {
                CardsView(activePaletteStyle = activePaletteStyle)
            }
            composable(Screen.Palette.route) {
                PaletteView(activePaletteStyle = activePaletteStyle)
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun HomeViewPreview() {
    AppTheme {
        HomeView()
    }
}