package com.example.scanner

import android.app.Application
import com.example.scanner.data.service.DatabaseFixtureService
import com.example.scanner.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin

class ScannerApplication : Application() {
    
    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ScannerApplication)
            modules(appModule)
        }
        
        // Initialiser les fixtures après que Koin soit prêt
        applicationScope.launch {
            val fixtureService = GlobalContext.get().get<DatabaseFixtureService>()
            fixtureService.seedDatabaseIfNeeded()
        }
    }
}
