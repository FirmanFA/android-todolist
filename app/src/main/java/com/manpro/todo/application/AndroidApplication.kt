package com.manpro.todo.application

import android.app.Application
import com.manpro.todo.di.networkModule
import com.manpro.todo.di.repositoryModule
import com.manpro.todo.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AndroidApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AndroidApplication)
            modules(networkModule, repositoryModule, viewModelModule)
        }


    }


}