package com.example.mvvmretrofitkt.di

import com.example.mvvmretrofitkt.network.APIService
import com.example.mvvmretrofitkt.repo.MyRepo
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class,RepoModule::class])
interface AppComponent  {
    fun getAPIService():APIService
    fun getRepo():MyRepo
}