import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.interop.UIKitViewController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import com.materialkolor.rememberDynamicColorScheme
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIViewController

@OptIn(ExperimentalForeignApi::class)
fun MainViewController(
    createUIViewController: (viewModel: CountViewModel) -> UIViewController
) = ComposeUIViewController {
    val viewModel = CountViewModel()
    Column(
        Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars),
    ) {
        val colorScheme = rememberDynamicColorScheme(Color(0xffff0000), false)
        val count by viewModel.count.collectAsState()

        App()
        Button(onClick = {
            viewModel.increment()
            viewModel.updateColorScheme(darkColorScheme())
        }) {
            Text("Increment: $count")
        }
        MaterialTheme(
            colorScheme = colorScheme
        ) {
            UIKitViewController(
                factory = { createUIViewController(viewModel) },
                modifier = Modifier
                    .size(300.dp)
                    .border(2.dp, MaterialTheme.colorScheme.outline)
            )
        }
    }
}