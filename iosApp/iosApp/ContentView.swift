import UIKit
import SwiftUI
import ComposeApp

struct ContentView: View {
    @Environment(\.colorScheme) var iosColorScheme

    var body: some View {
        SampleFormView(viewModel: ThemeViewModel(isDark: iosColorScheme == .dark)).ignoresSafeArea()
    }
}



