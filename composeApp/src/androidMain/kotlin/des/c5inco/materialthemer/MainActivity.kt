package des.c5inco.materialthemer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.materialkolor.DynamicMaterialTheme
import com.materialkolor.PaletteStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val useDarkIcons = isSystemInDarkTheme()
            DisposableEffect(useDarkIcons) {
                enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.auto(
                        android.graphics.Color.TRANSPARENT,
                        android.graphics.Color.TRANSPARENT,
                    ) { useDarkIcons },
                )
                onDispose {}
            }

            DynamicMaterialTheme(
                seedColor = Color.Red,
                useDarkTheme = useDarkIcons,
                style = PaletteStyle.TonalSpot
            ) {
                HomeView()
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    HomeView()
}