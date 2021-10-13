package com.example.shaadi.di

import android.content.Context
import com.example.shaadi.AppApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): AppApplication {
        return app as AppApplication
    }

}