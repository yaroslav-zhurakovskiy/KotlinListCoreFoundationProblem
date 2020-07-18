import SwiftUI
import shared

struct ContentView: View {
    var body: some View {
        VStack {
            UIViewWrapper(
                view: GradientViewKt.buildWithDirectColorsWithNSArray()
            )
            UIViewWrapper(
                view: GradientViewKt.buildWithDirectColorsWithList()
            )
            UIViewWrapper(
                view: GradientViewKt.buildWithColors(
                    colors: [
                        .red,
                        .green,
                        .black
                    ]
                )
            )
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

final class UIViewWrapper: UIViewRepresentable {
    typealias UIViewType = UIView
    
    private let view: UIView
    
    init(view: UIView) {
        self.view = view
    }
    
    func makeUIView(context: Context) -> UIViewType {
        return view
    }
    
    func updateUIView(_ uiView: UIViewType, context: Context) {
        
    }
}
