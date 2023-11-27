import SwiftUI
import ComposeApp
import FirebaseCore
//import Firebase
// "#import "FirebaseCore/FirebaseCore.h"
//import Firebase
// import FirebaseCore

@main
struct iOSApp: App {

    init() {
        FirebaseApp.configure()
        AppModuleKt.doInitKoin()
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
