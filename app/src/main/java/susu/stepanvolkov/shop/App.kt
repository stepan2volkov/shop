package susu.stepanvolkov.shop

import android.app.Application
import susu.stepanvolkov.shop.di.AppComponent
import susu.stepanvolkov.shop.di.DaggerAppComponent

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .context(this)
            .build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}