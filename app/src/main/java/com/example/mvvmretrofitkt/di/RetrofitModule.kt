package com.example.mvvmretrofitkt.di

import com.example.mvvmretrofitkt.network.APIService
import com.example.mvvmretrofitkt.network.RetroInstance
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class RetrofitModule  {
    @Provides
    fun retrofit(gsonConverterFactory: GsonConverterFactory):Retrofit{
        val baseUrl = "https://api.datamuse.com/"
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(gsonConverterFactory)
                .build()
    }
    @Provides
    fun gsonConverterFactory():GsonConverterFactory{
        return GsonConverterFactory.create()
    }
    @Provides
    fun apiService(retrofit: Retrofit):APIService{
        return retrofit.create(APIService::class.java)
    }
}