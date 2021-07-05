package com.example.mvvmretrofitkt.di

import com.example.mvvmretrofitkt.network.APIService
import com.example.mvvmretrofitkt.network.RetroInstance
import com.example.mvvmretrofitkt.repo.MyRepo
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class RetrofitModule  {
    @Singleton
    @Provides
    fun retrofit(gsonConverterFactory: GsonConverterFactory,rxJavaCallAdapterFactory: RxJava3CallAdapterFactory):Retrofit{
        val baseUrl = "https://api.datamuse.com/"
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build()
    }
    @Provides
    fun gsonConverterFactory(gson: Gson):GsonConverterFactory{
        return GsonConverterFactory.create(gson)
    }
    @Provides
    fun apiService(retrofit: Retrofit):APIService{
        return retrofit.create(APIService::class.java)
    }
    @Provides
    fun gson():Gson{
        return GsonBuilder()
                .serializeNulls()
                .create()
    }
    @Provides
    fun rxJavaCallAdapterFactory(): RxJava3CallAdapterFactory {
        return RxJava3CallAdapterFactory.create()

    }
}