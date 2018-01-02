package com.example.knifestart.hotelsnights.di.application.module

import com.example.knifestart.domain.api.IRemoteApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by glebkalinichenko on 01.01.18.
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideClient(networkTimeoutSecond: Long, logger: HttpLoggingInterceptor): OkHttpClient {

        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        okHttpClientBuilder.readTimeout(networkTimeoutSecond, TimeUnit.SECONDS)
        okHttpClientBuilder.connectTimeout(networkTimeoutSecond, TimeUnit.SECONDS)


        logger.level = HttpLoggingInterceptor.Level.BODY
        okHttpClientBuilder.addInterceptor(logger)

        return okHttpClientBuilder.build()

    }

    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient, baseUrl: String, converter: Converter.Factory): Retrofit =
            Retrofit.Builder().baseUrl(baseUrl).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(converter).client(httpClient).build()

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): IRemoteApi = retrofit.create(IRemoteApi::class.java)
}