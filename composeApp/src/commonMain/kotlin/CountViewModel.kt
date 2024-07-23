import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CountViewModel : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count.asStateFlow()

    private val _colorScheme = MutableStateFlow(lightColorScheme().toKotlinColorScheme())
    val colorScheme: StateFlow<KotlinColorScheme> = _colorScheme.asStateFlow()

    fun increment() {
        _count.update {
            it + 1
        }
    }

    fun updateColorScheme(newColorScheme: ColorScheme) {
        val kotlinScheme = newColorScheme.toKotlinColorScheme()
        _colorScheme.update {
            kotlinScheme
        }
    }
}