package com.android.data.di

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.datatype.joda.JodaModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { provideLoggingInterceptor() }
    single { provideObjectMapper() }

    // Services
    single { provideLoginApiService(get()) }
    single { provideOrderApiService(get()) }

    // Network clients
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get(), get(), getProperty("api_link")) }

}

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    objectMapper: ObjectMapper,
    link: String
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(link)
        .client(okHttpClient)
        .addConverterFactory(JacksonConverterFactory.create(objectMapper))
        .build()
}

private fun provideOkHttpClient(
    loggingInterceptor: HttpLoggingInterceptor
): OkHttpClient {
    return OkHttpClient().newBuilder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.MINUTES)
        .addInterceptor(loggingInterceptor)
        .build()
}

private fun provideObjectMapper(): ObjectMapper {
    val mapper = ObjectMapper()

    // Register modules
    mapper.registerKotlinModule()
    mapper.registerModule(JodaModule())
    mapper.findAndRegisterModules()

    // Config settings
    mapper.propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE

    return mapper
}

private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val logger = HttpLoggingInterceptor()
    logger.level = HttpLoggingInterceptor.Level.BODY
    return logger
}

// Service providers
private fun provideLoginApiService(retrofit: Retrofit): LoginApiService = retrofit.create(
    BaseApiService::class.java
)
