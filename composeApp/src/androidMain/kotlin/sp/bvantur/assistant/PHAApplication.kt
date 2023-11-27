package sp.bvantur.assistant

import android.app.Application
import android.util.Log
import com.google.firebase.FirebaseApp
import di.appModule
import org.koin.core.context.startKoin
import java.lang.Exception

class PHAApplication : Application() {

    private val internalModules =
        sequence {
            yieldAll(appModule())
        }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(internalModules.toList())
        }

        try {
            FirebaseApp.initializeApp(this)
        } catch (exc: Exception) {
            Log.e("", "${exc.message}")
        }
    }
}