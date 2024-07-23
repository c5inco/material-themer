import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController(createUIViewController: mainViewFactory)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
    }

    private func mainViewFactory(viewModel: CountViewModel) -> UIViewController {
       let swiftUIView = CountView(viewModel: viewModel)
       return UIHostingController(rootView: swiftUIView)
   }
}

struct CountView : View {
    var viewModel: CountViewModel

    var body: some View {
        VStack {
            Observing(viewModel.colorScheme) { colorScheme in
                let primary = colorScheme.primary
                let primaryContainer = colorScheme.primaryContainer
                let surface = colorScheme.surface
                let onSurface = colorScheme.onSurface
                
                VStack {
                    Text("\(primary)")
                        .foregroundColor(Color(red: primary.red, green: primary.green, blue: primary.blue))
                    Text("\(primaryContainer)")
                        .foregroundColor(Color(red: primaryContainer.red, green: primaryContainer.green, blue: primaryContainer.blue))
                }
                .background(Color(red: surface.red, green: surface.green, blue: surface.blue))
                .foregroundColor(Color(red: onSurface.red, green: onSurface.green, blue: onSurface.blue))
            }
        }
    }
}

struct ContentView: View {
    var body: some View {
        ComposeView()
                .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}



