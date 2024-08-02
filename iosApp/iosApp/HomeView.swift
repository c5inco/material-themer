import SwiftUI
import ComposeApp

let seedColors = [
    KotlinColor(red: 0.7019607843, green: 0.231372549, blue: 0.08235294118, alpha: 1.0),
    KotlinColor(red: 0.3882352941, green: 0.6274509804, blue: 0.007843137255, alpha: 1.0),
    KotlinColor(red: 0.462745098, green: 0.6117647059, blue: 0.8745098039, alpha: 1.0),
    KotlinColor(red: 1.0, green: 0.8705882353, blue: 0.2470588235, alpha: 1.0),
    KotlinColor(red: 0.2745098039, green: 0.2392156863, blue: 0.8745098039, alpha: 1.0),
    KotlinColor(red: 0.9529411765, green: 0.09411764706, blue: 0.7843137255, alpha: 1.0)
]

func toSwiftUiColor(kotlinColor: KotlinColor) -> Color {
    return Color(
        red: kotlinColor.red,
        green: kotlinColor.green,
        blue: kotlinColor.blue
    )
}

struct HomeView: View {
    @Environment(\.colorScheme) var iosColorScheme
    @State var viewModel: ThemeViewModel
    
    @State private var tabSelection = 3
    @State var activeSeedColor: KotlinColor = seedColors[0]
    @State var activePaletteStyle: Material_kolorPaletteStyle = .tonalSpot
    
    var body: some View {
        let colorScheme = viewModel.getDynamicColorScheme(
            seedColor: activeSeedColor,
            paletteStyle: activePaletteStyle,
            isDark: iosColorScheme == .dark
        )
        let surface = colorScheme.surface
        let primary = colorScheme.primary
        
        TabView(selection: $tabSelection) {
            Group {
                VStack {
                    NavigationStack {
                        FormView(colorScheme: colorScheme)
                            .toolbar {
                                ToolbarView(
                                    selectedColor: activeSeedColor,
                                    selectedStyle: activePaletteStyle,
                                    onColorSelect: updateActiveSeedColor,
                                    onStyleSelect: updateActivePaletteStyle
                                )
                            }
                            .navigationTitle("\(activePaletteStyle) form")
                            .background(toSwiftUiColor(kotlinColor: surface))
                    }
                }.tabItem {
                    Label("Form", systemImage: "gear")
                }
                .tag(1)
                
                VStack {
                    NavigationStack {
                        CardsView(colorScheme: colorScheme)
                            .toolbar {
                                ToolbarView(
                                    selectedColor: activeSeedColor,
                                    selectedStyle: activePaletteStyle,
                                    onColorSelect: updateActiveSeedColor,
                                    onStyleSelect: updateActivePaletteStyle
                                )
                            }
                            .navigationTitle("\(activePaletteStyle) cards")
                            .background(toSwiftUiColor(kotlinColor: surface))
                    }
                }
                .tabItem {
                    Label("Cards", systemImage: "person.text.rectangle")
                }
                .tag(2)
                
                VStack {
                    NavigationStack {
                        PaletteView(colorScheme: colorScheme)
                            .toolbar {
                                ToolbarView(
                                    selectedColor: activeSeedColor,
                                    selectedStyle: activePaletteStyle,
                                    onColorSelect: updateActiveSeedColor,
                                    onStyleSelect: updateActivePaletteStyle
                                )
                            }
                            .navigationTitle("\(activePaletteStyle) palette")
                            .background(toSwiftUiColor(kotlinColor: colorScheme.surface))
                    }
                }
                .tabItem {
                    Label("Palette", systemImage: "square.3.layers.3d.down.right")
                }
                .tag(3)
            }
            .toolbarBackground(.visible, for: .tabBar)
            .navigationBarModifier(
                foregroundColor: UIColor(toSwiftUiColor(kotlinColor: colorScheme.onSurfaceVariant)),
                tintColor: UIColor(toSwiftUiColor(kotlinColor: colorScheme.onSurfaceVariant)))
        }
        .accentColor(toSwiftUiColor(kotlinColor: primary))
    }
    
    func updateActiveSeedColor(color: KotlinColor) {
        activeSeedColor = color
    }
    
    func updateActivePaletteStyle(style: Material_kolorPaletteStyle) {
        activePaletteStyle = style
    }
}

struct ToolbarView: ToolbarContent {
    @State var selectedColor: KotlinColor
    let selectedStyle: Material_kolorPaletteStyle
    let onColorSelect: (KotlinColor) -> Void
    let onStyleSelect: (Material_kolorPaletteStyle) -> Void

    init(
        selectedColor: KotlinColor,
        selectedStyle: Material_kolorPaletteStyle,
        onColorSelect: @escaping (KotlinColor) -> Void,
        onStyleSelect: @escaping (Material_kolorPaletteStyle) -> Void
    ) {
        self.selectedColor = selectedColor
        self.selectedStyle = selectedStyle
        self.onColorSelect = onColorSelect
        self.onStyleSelect = onStyleSelect
    }
    
    var body: some ToolbarContent {
        ToolbarItem(placement: .primaryAction) {
            Menu {
                Picker("Color Palette", selection: $selectedColor) {
                    ForEach(seedColors, id: \.self) { seedColor in
                        Image(systemName: selectedColor == seedColor ? "checkmark.circle.fill" : "circle.fill")
                            .tint(toSwiftUiColor(kotlinColor: seedColor))
                            .tag(seedColor)
                    }
                  }
                  .pickerStyle(.palette)
                  .paletteSelectionEffect(.custom)
                  .menuActionDismissBehavior(.enabled)
                  .onChange(of: selectedColor) { _, newColor in
                      onColorSelect(newColor)
                  }
                
                ForEach(Material_kolorPaletteStyle.allCases, id: \.self) { style in
                    Button(action: {
                        onStyleSelect(style)
                    }) {
                        if (selectedStyle == style) {
                            Label("\(style)", systemImage: "checkmark")
                        } else {
                            Text("\(style)")
                        }
                    }
                }
            } label: {
                Image(systemName: "swatchpalette.fill")
                    .imageScale(.large)
            }
        }
        ToolbarItem(placement: .topBarLeading) {
            Button(action: {
                
            }) {
                Image(systemName: "visionpro")
                    .imageScale(.large)
            }
        }
    }
}

#Preview {
    HomeView(viewModel: ThemeViewModel(isDark: false))
}
