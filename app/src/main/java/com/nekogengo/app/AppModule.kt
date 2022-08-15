package com.nekogengo.app

import com.nekogengo.repository.GitDbRepository
import com.nekogengo.services.GitDbServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    factory {
        OkHttpClient.Builder().apply {
            val httpLoggingInterceptor = HttpLoggingInterceptor().apply { level = Level.BASIC }
            interceptors().add(httpLoggingInterceptor)
        }.build()
    }

    factory {
        Retrofit.Builder()
            .client(get())
            .baseUrl("https://raw.githubusercontent.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    factory {
        val retrofit = get<Retrofit>()

        retrofit.create(GitDbServices::class.java)
    }

    factory {
        GitDbRepository(get())
    }
}