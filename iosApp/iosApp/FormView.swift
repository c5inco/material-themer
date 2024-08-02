//
//  FormView.swift
//  iosApp
//
//  Created by Chris Sinco on 8/1/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import ComposeApp

struct FormView: View {
    var colorScheme: KotlinColorScheme
    
    @State var enableLogging = true
    @State private var index = 0
    @State var stepper = 1
    @State var name = ""
    @State var colors = ["Red", "Green", "Blue"]
    
    var body: some View {
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
                .listRowBackground(toSwiftUiColor(kotlinColor: colorScheme.surfaceContainer))
                
                Section {
                    Stepper("Title", value: $stepper)
                    Toggle(isOn: $enableLogging) {
                        Text("Title")
                    }
                    .tint(toSwiftUiColor(kotlinColor: colorScheme.tertiary))
                }
                .listRowBackground(toSwiftUiColor(kotlinColor: colorScheme.surfaceContainer))
                
                Button("Action") { }
            }
            .scrollContentBackground(.hidden)
        }
    }
}

#Preview {
    struct PreviewView: View {
        @Environment(\.colorScheme) var iosColorScheme
        
        var body: some View {
            let viewModel = ThemeViewModel(isDark: iosColorScheme == .dark)
            VStack {
                FormView(colorScheme: viewModel.getDynamicColorScheme(
                    seedColor: seedColors[0],
                    paletteStyle: .expressive,
                    isDark: iosColorScheme == .dark
                ))
            }
        }
    }
    return PreviewView()
}
