import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import ui.App

fun MainViewController(): UIViewController =
    ComposeUIViewController {
        App()
    }