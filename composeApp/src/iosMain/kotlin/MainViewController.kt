import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitViewController
import androidx.compose.ui.window.ComposeUIViewController
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIViewController

@OptIn(ExperimentalForeignApi::class)
fun MainViewController(
    createUIViewController: (viewModel: ThemeViewModel) -> UIViewController
) = ComposeUIViewController {
    UIKitViewController(
        factory = { createUIViewController(ThemeViewModel()) },
        modifier = Modifier.fillMaxSize(),
    )
}