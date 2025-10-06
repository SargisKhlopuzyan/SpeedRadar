package com.sargis.khlopuzyan.speedradar

import android.app.Application
import com.sargis.khlopuzyan.data.di.dataModule
import com.sargis.khlopuzyan.domain.di.domainModule
import com.sargis.khlopuzyan.presentation.ui.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class SpeedRadarApp : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SpeedRadarApp)
            modules(dataModule + domainModule + presentationModule)
        }
    }
}