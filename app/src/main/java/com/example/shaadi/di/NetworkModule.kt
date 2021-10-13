package com.example.shaadi.di

import android.content.Context
import android.util.Log
import com.example.shaadi.AppApplication
import com.example.shaadi.common.CommonConstant
import com.example.shaadi.network.NetworkServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit


@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    fun provideRetrofit(
        converterFactory: Converter.Factory,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(CommonConstant.baseUrl)
        .addConverterFactory(converterFactory)
        .addCallAdapterFactory(rxJava2CallAdapterFactory)
        .client(okHttpClient)
        .build()




    @Provides
    fun provideNetworkServices(retrofit: Retrofit)
            : NetworkServices = retrofit.create(NetworkServices::class.java)


    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }


    @Provides
    fun provideOkHttpBuilder(logger: HttpLoggingInterceptor,appApplication: AppApplication): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()




        okHttpBuilder.addInterceptor(logger)
        okHttpBuilder.callTimeout(60, TimeUnit.SECONDS)
        okHttpBuilder.connectTimeout(60, TimeUnit.SECONDS)
        okHttpBuilder.writeTimeout(60, TimeUnit.SECONDS)
        okHttpBuilder.readTimeout(60, TimeUnit.SECONDS)
        okHttpBuilder.retryOnConnectionFailure(true)


        val okhttp = okHttpBuilder.build()

        return okhttp

    }


    @Provides
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideRxJava2CallAdapterFactory() = RxJava2CallAdapterFactory.create()


}