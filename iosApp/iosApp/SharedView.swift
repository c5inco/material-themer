//
//  SharedView.swift
//  iosApp
//
//  Created by Chris Sinco on 8/28/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        return MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
    }
}

struct SharedView: View {
    var body: some View {
        ComposeView()
    }
}

#Preview {
    SharedView()
}
