import SwiftUI
import ComposeApp

let seedColors = [
    KotlinColor(red: 0.7019607843, green: 0.231372549, blue: 0.08235294118, alpha: 1.0),
    KotlinColor(red: 0.3882352941, green: 0.6274509804, blue: 0.007843137255, alpha: 1.0),
    KotlinColor(red: 0.462745098, green: 0.6117647059, blue: 0.8745098039, alpha: 1.0),
    KotlinColor(red: 1.0, green: 0.8705882353, blue: 0.2470588235, alpha: 1.0),
]

func toSwiftUiColor(kotlinColor: KotlinColor) -> Color {
    return Color(
        red: kotlinColor.red,
        green: kotlinColor.green,
        blue: kotlinColor.blue
    )
}

struct SampleFormView: View {
    @Environment(\.colorScheme) var iosColorScheme
    @State var viewModel: ThemeViewModel

    @State var enableLogging = true
    @State private var index = 0
    @State var stepper = 1
    @State var name = ""
    @State var colors = ["Red", "Green", "Blue"]
    @State var activeSeedColor: KotlinColor = seedColors[0]
    @State var seedIndex = 0
    
    var body: some View {
        let colorScheme = viewModel.getDynamicColorScheme(
            seedColor: activeSeedColor,
            isDark: iosColorScheme == .dark
        )
        let surface = colorScheme.surface
        let surfaceContainer = colorScheme.surfaceContainer
        let primary = colorScheme.primary
        
        TabView {
            Group {
                VStack {
                    NavigationStack {
                        VStack {
                            Form {
                                TextField("Search", text: $name)
                                Section {
                                    Text("Title")
                                }
                                
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
                                    
                                    HStack {
                                        Text("Title")
                                        Spacer()
                                        Image(systemName: "info.circle")
                                            .imageScale(.large)
                                            .foregroundStyle(.tint)
                                    }
                                    HStack {
                                        Text("Title")
                                        Spacer()
                                        Image(systemName: "star")
                                            .imageScale(.large)
                                            .foregroundStyle(.tint)
                                    }
                                    HStack {
                                        Text("Title")
                                        Spacer()
                                        Image(systemName: "checkmark")
                                            .imageScale(.large)
                                            .foregroundStyle(.tint)
                                    }
                                }
                                .listRowBackground(toSwiftUiColor(kotlinColor: surfaceContainer))
                                
                                Section {
                                    Stepper("Title", value: $stepper)
                                    Toggle(isOn: $enableLogging) {
                                        Text("Title")
                                    }
                                    .tint(toSwiftUiColor(kotlinColor: colorScheme.tertiary))
                                }
                                .listRowBackground(toSwiftUiColor(kotlinColor: surfaceContainer))
                                
                                Button("Action") { }
                            }
                            .scrollContentBackground(.hidden)
                        }
                        .toolbar {
                            ToolbarView(action: updateActiveSeedColor, selectedColor: activeSeedColor)
                        }
                        .navigationTitle("Sample form")
                        .background(toSwiftUiColor(kotlinColor: surface))
                    }
                }.tabItem {
                    Label("Form", systemImage: "gear")
                }
                
                VStack {
                    Text("Show list here")
                }
                .tabItem {
                    Label("Cards", systemImage: "person.text.rectangle")
                }
                
                VStack {
                    Text("Show palettes here")
                }.tabItem {
                    Label("Palettes", systemImage: "square.3.layers.3d.down.right")
                }
                .background(toSwiftUiColor(kotlinColor: surface))
            }
            .toolbarBackground(.visible, for: .tabBar)
        }
        .accentColor(toSwiftUiColor(kotlinColor: primary))
    }
    
    func updateActiveSeedColor(color: KotlinColor) {
        print(color)
        activeSeedColor = color
    }
}

struct ToolbarView: ToolbarContent {
    let action: (KotlinColor) -> Void
    @State var selectedColor: KotlinColor

    init(action: @escaping (KotlinColor) -> Void, selectedColor: KotlinColor) {
        self.action = action
        self.selectedColor = selectedColor
    }
    
    var body: some ToolbarContent {
        ToolbarItem(placement: .primaryAction) {
            Menu {
                Picker("Color Palette", selection: $selectedColor) {
                    ForEach(seedColors, id: \.self) { seedColor in
                        Image(systemName: "circle.fill")
                            .tint(toSwiftUiColor(kotlinColor: seedColor))
                    }
                  }
                  .pickerStyle(.palette)
                  .menuActionDismissBehavior(.enabled)
                  .onChange(of: selectedColor) { _, newColor in
                      action(newColor)
                  }
            } label: {
                Image(systemName: "swatchpalette.fill")
                    .imageScale(.large)
            }
        }
        ToolbarItem(placement: .topBarLeading) {
            Button(action: {
                
            }) {
                Image(systemName: "person.crop.circle")
                    .imageScale(.large)
            }
        }
    }
}

#Preview {
    SampleFormView(viewModel: ThemeViewModel(isDark: false))
}
