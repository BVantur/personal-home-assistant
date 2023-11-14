package sp.bvantur.assistant

import android.app.Application
import di.appModule
import org.koin.core.context.startKoin

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
    }
}