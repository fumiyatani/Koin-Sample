package com.example.koinsample

import android.app.Application
import com.example.koinsample.data.GitHubRepository
import com.example.koinsample.data.GitHubRepositoryImpl
import com.example.koinsample.ui.first.FirstViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class KoinSampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@KoinSampleApplication)
            modules(module)
        }
    }
}

val module = module {
    single<GitHubRepository> { GitHubRepositoryImpl.getInstance() }
    viewModel { FirstViewModel(get()) }
}