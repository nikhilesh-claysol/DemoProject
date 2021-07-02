package com.example.mvvmretrofitkt.di

import com.example.mvvmretrofitkt.network.APIService
import com.example.mvvmretrofitkt.network.RetroInstance
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class RetrofitModule  {
    @Singleton
    @Provides
    fun retrofit(gsonConverterFactory: GsonConverterFactory):Retrofit{
        val baseUrl = "https://api.datamuse.com/"
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(gsonConverterFactory)
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
}