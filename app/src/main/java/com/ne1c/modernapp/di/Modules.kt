package com.ne1c.modernapp.di

import android.arch.persistence.room.Room
import android.content.Context
import android.net.ConnectivityManager
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.ne1c.modernapp.android.NetworkStateImpl
import com.ne1c.modernapp.data.db.source.DatabaseSource
import com.ne1c.modernapp.data.network.api.GithubApi
import com.ne1c.modernapp.data.network.source.NetworkDataSource
import com.ne1c.modernapp.domain.NetworkState
import com.ne1c.modernapp.domain.interactor.RepoInteractor
import com.ne1c.modernapp.domain.repositoty.RepoRepository
import com.ne1c.modernapp.domain.repositoty.RepoRepositoryImpl
import com.ne1c.modernapp.presentation.main.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.architecture.ext.viewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = applicationContext {
    bean { NetworkDataSource(get()) }
    bean {
        Retrofit.Builder()
                .client(OkHttpClient.Builder()
                        .addInterceptor(HttpLoggingInterceptor()
                                .apply { level = HttpLoggingInterceptor.Level.BODY })
                        .build())
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(GithubApi::class.java)
    }
    bean {
        NetworkStateImpl(androidApplication()
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager) as NetworkState
    }
}

val databaseModule = applicationContext {
    bean {
        Room.databaseBuilder(androidApplication(), DatabaseSource::class.java, "db")
                .build()
    }
}

val mainModule = applicationContext {
    viewModel { MainViewModel(get()) }
    bean { RepoInteractor(get()) }
    bean { RepoRepositoryImpl(get(), get(), get()) as RepoRepository }
}