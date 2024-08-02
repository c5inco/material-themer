//
//  NavigationBarViewModifier.swift
//  iosApp
//
//  Created by Chris Sinco on 8/1/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct NavigationBarViewModifier: ViewModifier {
    init(backgroundColor: UIColor = .systemBackground, foregroundColor: UIColor = .blue, tintColor: UIColor? = nil) {
            let navBarAppearance = UINavigationBarAppearance()
            navBarAppearance.titleTextAttributes = [.foregroundColor: foregroundColor]
            navBarAppearance.largeTitleTextAttributes = [.foregroundColor: foregroundColor]
            UINavigationBar.appearance().standardAppearance = navBarAppearance
        
//            UINavigationBar.appearance().compactAppearance = navBarAppearance
        
            let scrollNavBarAppearance = UINavigationBarAppearance()
            scrollNavBarAppearance.titleTextAttributes = [.foregroundColor: foregroundColor]
            scrollNavBarAppearance.largeTitleTextAttributes = [.foregroundColor: foregroundColor]
            scrollNavBarAppearance.backgroundColor = backgroundColor
            scrollNavBarAppearance.shadowColor = .clear
            UINavigationBar.appearance().scrollEdgeAppearance = scrollNavBarAppearance
            
            if let tintColor = tintColor {
                UINavigationBar.appearance().tintColor = tintColor
            }
        }
    
    func body(content: Content) -> some View {
        content
    }
}

extension View {
    func navigationBarModifier(
        backgroundColor: UIColor = .systemBackground,
        foregroundColor: UIColor = .label,
        tintColor: UIColor? = nil) -> some View
    {
        self.modifier(NavigationBarViewModifier(backgroundColor: backgroundColor, foregroundColor: foregroundColor, tintColor: tintColor))
    }
}

#Preview {
    NavigationStack {
        Text("My Text Text")
            .navigationTitle("Test title")
            .navigationBarModifier(
                backgroundColor: .systemBackground,
                foregroundColor: .systemBlue
            )
    }
}
