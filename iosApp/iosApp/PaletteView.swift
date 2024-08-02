//
//  PaletteView.swift
//  iosApp
//
//  Created by Chris Sinco on 8/1/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import ComposeApp

struct PaletteView: View {
    var colorScheme: KotlinColorScheme
    
    var body: some View {
        ScrollView {
            VStack(spacing: 20) {
                HStack {
                    PairedSwatch(
                        label: "primary",
                        background: colorScheme.primary,
                        foreground: colorScheme.onPrimary,
                        onLabel: "onPrimary",
                        onBackground: colorScheme.onPrimary,
                        onForeground: colorScheme.primary
                    )
                }
                
                HStack {
                    PairedSwatch(
                        label: "secondary",
                        background: colorScheme.secondary,
                        foreground: colorScheme.onSecondary,
                        onLabel: "onSecondary",
                        onBackground: colorScheme.onSecondary,
                        onForeground: colorScheme.secondary
                    )
                    Spacer().frame(width: 12)
                    PairedSwatch(
                        label: "tertiary",
                        background: colorScheme.tertiary,
                        foreground: colorScheme.onTertiary,
                        onLabel: "onTertiary",
                        onBackground: colorScheme.onTertiary,
                        onForeground: colorScheme.tertiary
                    )
                }
                
                HStack {
                    PairedSwatch(
                        label: "primaryContainer",
                        background: colorScheme.primaryContainer,
                        foreground: colorScheme.onPrimaryContainer,
                        onLabel: "onPrimaryContainer",
                        onBackground: colorScheme.onPrimaryContainer,
                        onForeground: colorScheme.primaryContainer
                    )
                }
                
                HStack {
                    PairedSwatch(
                        label: "secondaryContainer",
                        background: colorScheme.secondaryContainer,
                        foreground: colorScheme.onSecondaryContainer,
                        onLabel: "onSecondaryContainer",
                        onBackground: colorScheme.onSecondaryContainer,
                        onForeground: colorScheme.secondaryContainer
                    )
                    Spacer().frame(width: 12)
                    PairedSwatch(
                        label: "tertiaryContainer",
                        background: colorScheme.tertiaryContainer,
                        foreground: colorScheme.onTertiaryContainer,
                        onLabel: "onTertiaryContainer",
                        onBackground: colorScheme.onTertiaryContainer,
                        onForeground: colorScheme.tertiaryContainer
                    )
                }
                
                HStack {
                    PairedSwatch(
                        label: "error",
                        background: colorScheme.error,
                        foreground: colorScheme.onError,
                        onLabel: "onError",
                        onBackground: colorScheme.onError,
                        onForeground: colorScheme.error
                    )
                    Spacer().frame(width: 12)
                    PairedSwatch(
                        label: "errorContainer",
                        background: colorScheme.errorContainer,
                        foreground: colorScheme.onErrorContainer,
                        onLabel: "onErrorContainer",
                        onBackground: colorScheme.onErrorContainer,
                        onForeground: colorScheme.errorContainer
                    )
                }
                
                HStack {
                    Swatch(
                        label: "surfaceDim",
                        background: colorScheme.surfaceDim,
                        foreground: colorScheme.onSurface
                    )
                    Spacer().frame(width: 12)
                    Swatch(
                        label: "surfaceBright",
                        background: colorScheme.surfaceBright,
                        foreground: colorScheme.onSurface
                    )
                }
                
                HStack {
                    Swatch(
                        label: "surface",
                        background: colorScheme.surface,
                        foreground: colorScheme.onSurface
                    )
                }
                
                HStack {
                    PairedSwatch(
                        label: "inverseSurface",
                        background: colorScheme.inverseSurface,
                        foreground: colorScheme.inverseOnSurface,
                        onLabel: "inverseOnSurface",
                        onBackground: colorScheme.inverseOnSurface,
                        onForeground: colorScheme.inverseSurface
                    )
                }
                
                HStack {
                    Swatch(
                        label: "inversePrimary",
                        background: colorScheme.inversePrimary,
                        foreground: colorScheme.onPrimaryContainer
                    )
                }
                
                HStack {
                    Swatch(
                        label: "surfaceContainerLow",
                        background: colorScheme.surfaceContainerLow,
                        foreground: colorScheme.onSurface
                    )
                    Spacer().frame(width: 12)
                    Swatch(
                        label: "surfaceContinerLowest",
                        background: colorScheme.surfaceContainerLowest,
                        foreground: colorScheme.onSurface
                    )
                }
                
                HStack {
                    Swatch(
                        label: "surfaceContainer",
                        background: colorScheme.surfaceContainer,
                        foreground: colorScheme.onSurface
                    )
                }
                
                HStack {
                    Swatch(
                        label: "surfaceContainerHigh",
                        background: colorScheme.surfaceContainerHigh,
                        foreground: colorScheme.onSurface
                    )
                    Spacer().frame(width: 12)
                    Swatch(
                        label: "surfaceContinerHighest",
                        background: colorScheme.surfaceContainerHighest,
                        foreground: colorScheme.onSurface
                    )
                }
                
                HStack {
                    Swatch(
                        label: "outline",
                        background: colorScheme.outline,
                        foreground: colorScheme.inverseOnSurface
                    )
                    Spacer().frame(width: 12)
                    Swatch(
                        label: "outlineVariant",
                        background: colorScheme.outlineVariant,
                        foreground: colorScheme.inverseSurface
                    )
                }
            }
            .padding()
        }
    }
}

struct Swatch: View {
    var label: String
    var background: KotlinColor
    var foreground: KotlinColor
    
    var body: some View {
        ZStack(alignment: .bottomLeading) {
            Text(label)
                .font(.caption)
                .foregroundColor(toSwiftUiColor(kotlinColor: foreground))
                .padding()
            Spacer()
                .frame(width: .infinity, height: 80)
                
        }
        .background(toSwiftUiColor(kotlinColor: background))
        .clipShape(RoundedRectangle(cornerRadius: 24.0))
    }
}

struct PairedSwatch: View {
    var label: String
    var background: KotlinColor
    var foreground: KotlinColor
    var onLabel: String
    var onBackground: KotlinColor
    var onForeground: KotlinColor
    
    var body: some View {
        VStack {
            ZStack(alignment: .topLeading) {
                Text(label)
                    .font(.caption)
                    .foregroundColor(toSwiftUiColor(kotlinColor: foreground))
                    .padding()
                Spacer()
                    .frame(width: .infinity, height: 100)
                    
            }
            .background(toSwiftUiColor(kotlinColor: background))
            
            HStack {
                Text(onLabel)
                    .font(.caption)
                    .foregroundColor(toSwiftUiColor(kotlinColor: onForeground))
                    .padding()
                Spacer()
            }
            .background(toSwiftUiColor(kotlinColor: onBackground))
        }
        .clipShape(RoundedRectangle(cornerRadius: 24.0))
    }
}

#Preview {
    struct PreviewView: View {
        @Environment(\.colorScheme) var iosColorScheme
        
        var body: some View {
            let viewModel = ThemeViewModel(isDark: iosColorScheme == .dark)
            
            NavigationStack {
                PaletteView(colorScheme: viewModel.getDynamicColorScheme(
                    seedColor: seedColors[0],
                    paletteStyle: .expressive,
                    isDark: iosColorScheme == .dark
                ))
                .background(Color.black)
            }
            
        }
    }
    return PreviewView()
}
