import UIKit
import SwiftUI
import ComposeApp

struct ContentView: View {
    @Environment(\.colorScheme) var iosColorScheme

    var body: some View {
        HomeView(viewModel: ThemeViewModel(isDark: iosColorScheme == .dark))
    }
}

#Preview {
    ContentView()
}
