//
//  CardsView.swift
//  iosApp
//
//  Created by Chris Sinco on 7/31/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import ComposeApp

enum ProductType {
    case accessories
    case devices
    case displays
}

struct Card: Identifiable {
    let id = UUID()
    let sfIcon: String
    let title: String
    let type: ProductType
    let price: Double
}

struct CardsView: View {
    var colorScheme: KotlinColorScheme
    
    var body: some View {
        let cards = [
            Card(sfIcon: "visionpro", title: "Vision Pro", type: .devices, price: 3999.0),
            Card(sfIcon: "macbook", title: "Macbook Air", type: .displays, price: 999.0),
            Card(sfIcon: "magicmouse", title: "Magic Mouse", type: .accessories, price: 199.0),
            Card(sfIcon: "iphone", title: "iPhone 15", type: .devices, price: 999.0),
            Card(sfIcon: "macstudio", title: "Mac Studio", type: .displays, price: 1999.0),
            Card(sfIcon: "applewatch", title: "Apple Watch", type: .devices, price: 799.0),
            Card(sfIcon: "airpodspro", title: "Airpods Pro", type: .accessories, price: 249.0),
            Card(sfIcon: "macpro.gen1", title: "Mac Pro", type: .displays, price: 4999.0),
            Card(sfIcon: "ipad", title: "iPad", type: .devices, price: 499.0),
            Card(sfIcon: "airpods", title: "Airpods", type: .accessories, price: 199.0),
            Card(sfIcon: "airpodsmax", title: "Airpods Max", type: .accessories, price: 699.0),
            Card(sfIcon: "macmini", title: "Mac Mini", type: .displays, price: 799.0),
            Card(sfIcon: "appletv", title: "Apple TV", type: .devices, price: 499.0),
        ]
        
        ScrollView {
            LazyVGrid(columns: [GridItem(.flexible()), GridItem(.flexible())]) {
                ForEach(cards, id: \.self.id) { card in
                    ZStack {
                        RoundedRectangle(cornerRadius: 24.0)
                            .foregroundColor(getSurfaceColor(type: card.type))
                            .frame(height: .infinity)
                        VStack {
                            Image(systemName: card.sfIcon)
                                .font(.system(size: 64))
                                .fontWeight(.ultraLight)
                                .foregroundColor(getOnSurfaceColor(type: card.type))
                            Spacer().frame(height: 20)
                            Text(card.title)
                                .font(.headline)
                                .foregroundColor(getOnSurfaceColor(type: card.type))
                                .multilineTextAlignment(.center)
                            Spacer().frame(height: 4)
                            Text(card.price.formatted(.currency(code: "USD")))
                                .font(.subheadline)
                                .foregroundColor(getOnSurfaceColor(type: card.type))
                        }
                        .padding()
                    }
                    .frame(height: 200)
                }
            }
            .padding()
        }
    }
    
    private func getOnSurfaceColor(type: ProductType) -> Color {
        let color = switch type {
            case .devices:
                colorScheme.onPrimaryContainer
            case .accessories:
                colorScheme.onSecondaryContainer
            case .displays:
                colorScheme.onTertiaryContainer
        }
        
        return toSwiftUiColor(kotlinColor: color)
    }
    
    private func getSurfaceColor(type: ProductType) -> Color {
        let color = switch type {
            case .devices:
                colorScheme.primaryContainer
            case .accessories:
                colorScheme.surfaceVariant
            case .displays:
                colorScheme.tertiaryContainer
        }
        
        return toSwiftUiColor(kotlinColor: color)
    }
}

#Preview {
    struct PreviewView: View {
        @Environment(\.colorScheme) var iosColorScheme
        
        var body: some View {
            let viewModel = ThemeViewModel(isDark: iosColorScheme == .dark)
            VStack {
                CardsView(colorScheme: viewModel.getDynamicColorScheme(
                    seedColor: seedColors[0],
                    paletteStyle: .expressive,
                    isDark: iosColorScheme == .dark
                ))
            }
        }
    }
    return PreviewView()
}
