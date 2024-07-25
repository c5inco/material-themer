import SwiftUI
import ComposeApp

struct SampleFormView: View {
    var viewModel: CountViewModel

    @State var enableLogging = true
    @State private var index = 0
    @State var stepper = 1
    @State var name = ""
    @State var colors = ["Red", "Green", "Blue"]

    var body: some View {
        Observing(viewModel.colorScheme) { colorScheme in
            let surface = colorScheme.surface
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
                            
                            Picker("Title", selection: $index) {
                                ForEach(colors, id: \.self) { option in
                                    Text(option)
                                }
                            }
                            .pickerStyle(.navigationLink)
                        }
                        
                        Section {
                            Stepper("Title", value: $stepper)
                            Toggle(isOn: $enableLogging) {
                                Text("Title")
                            }
                            .tint(Color(red: secondary.red, green: secondary.green, blue: secondary.blue))
                        }
                        Button("Action") { }
                    }
                    .scrollContentBackground(.hidden)
                }
                .toolbar {
                    ToolbarItem(placement: .primaryAction) {
                        Image(systemName: "visionpro")
                            .imageScale(.large)
                            .foregroundColor(Color(red: primary.red, green: primary.green, blue: primary.blue))
                    }
                    ToolbarItem(placement: .topBarLeading) {
                        Image(systemName: "person.crop.circle")
                            .imageScale(.large)
                            .foregroundColor(Color(red: primary.red, green: primary.green, blue: primary.blue))
                    }
                }
                .navigationTitle("Inset Lists")
                .background(Color(red: surface.red, green: surface.green, blue: surface.blue))
            }
        }
    }
}
