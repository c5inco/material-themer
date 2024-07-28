import SwiftUI
import ComposeApp

struct SampleFormView: View {
    @Environment(\.colorScheme) var iosColorScheme
    var viewModel: ThemeViewModel

    @State var enableLogging = true
    @State private var index = 0
    @State var stepper = 1
    @State var name = ""
    @State var colors = ["Red", "Green", "Blue"]
    @State var seedIndex = 0

    var body: some View {
        Observing (viewModel.activeSeedColor) { activeColor in
            let colorScheme = viewModel.getDynamicColorScheme(isDark: iosColorScheme == .dark)
            let surface = colorScheme.surface
            let surfaceContainerLowest = colorScheme.surfaceContainer
            let primary = colorScheme.primary
            let secondary = colorScheme.secondary

            NavigationStack {
                VStack {
                    Form {
                        TextField("Search", text: $name)
                        Section(
                            header: Text("Header Text"),
                            footer: Text("Footer")
                        ) {
                            Picker("Title", selection: $index) {
                                ForEach(colors, id: \.self) { option in
                                    Text(option)
                                }
                            }
                            .pickerStyle(.navigationLink)

                            Picker("Title", selection: $index) {
                                ForEach(colors, id: \.self) { option in
                                    Text(option)
                                }
                            }
                            .pickerStyle(.navigationLink)

                            HStack {
                                Text("Title")
                                Spacer()
                                Image(systemName: "info.circle")
                                    .imageScale(.large)
                                    .foregroundColor(toSwiftUiColor(kotlinColor: primary))
                            }
                            HStack {
                                Text("Title")
                                Spacer()
                                Image(systemName: "star")
                                    .imageScale(.large)
                                    .foregroundColor(toSwiftUiColor(kotlinColor: primary))
                            }
                            HStack {
                                Text("Title")
                                Spacer()
                                Image(systemName: "checkmark")
                                    .imageScale(.large)
                                    .foregroundColor(toSwiftUiColor(kotlinColor: primary))
                            }

                            Picker("Title", selection: $index) {
                                ForEach(colors, id: \.self) { option in
                                    Text(option)
                                }
                            }
                            .pickerStyle(.navigationLink)
                        }
                        .listRowBackground(toSwiftUiColor(kotlinColor: surfaceContainerLowest))

                        Section {
                            Stepper("Title", value: $stepper)
                            Toggle(isOn: $enableLogging) {
                                Text("Title")
                            }
                            .tint(toSwiftUiColor(kotlinColor: secondary))
                        }
                        .listRowBackground(toSwiftUiColor(kotlinColor: surfaceContainerLowest))

                        Button("Action") { }
                            .foregroundColor(toSwiftUiColor(kotlinColor: primary))
                    }
                    .scrollContentBackground(.hidden)
                }
                .toolbar {
                    ToolbarItem(placement: .primaryAction) {
                        Button(action: {
                            viewModel.updateSeedColor(index: 2)
                        }) {
                            Image(systemName: "visionpro")
                                .imageScale(.large)
                                .foregroundColor(toSwiftUiColor(kotlinColor: primary))
                        }
                    }
                    ToolbarItem(placement: .topBarLeading) {
                        Button(action: {
                            viewModel.updateSeedColor(index: 3)
                        }) {
                            Image(systemName: "person.crop.circle")
                                .imageScale(.large)
                                .foregroundColor(toSwiftUiColor(kotlinColor: primary))
                        }
                    }
                }
                .navigationTitle("Inset Lists")
                .background(toSwiftUiColor(kotlinColor: surface))
            }
        }
    }
    
    private func toSwiftUiColor(kotlinColor: KotlinColor) -> Color {
        return Color(
            red: kotlinColor.red,
            green: kotlinColor.green,
            blue: kotlinColor.blue
        )
    }
}

#Preview {
    SampleFormView(viewModel: ThemeViewModel(isDark: false))
}
