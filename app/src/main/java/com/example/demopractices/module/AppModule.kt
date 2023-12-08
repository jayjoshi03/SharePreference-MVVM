package com.example.demopractices.module

import android.content.Context
import com.example.demopractices.repository.SharedPreferencesManager
import com.example.demopractices.repository.SharedPreferencesManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module @InstallIn(SingletonComponent::class) class AppModule {

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides @Singleton fun provideSharedPreferencesManager(context : Context) : SharedPreferencesManager {
        return SharedPreferencesManagerImpl(context)
    }

}