package com.example.mvvmretrofitkt.di

import com.example.mvvmretrofitkt.MainActivity
import com.example.mvvmretrofitkt.network.APIService
import com.example.mvvmretrofitkt.repo.MyRepo
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class,RepoModule::class,AndroidSupportInjectionModule::class,ViewModelFactoryModule::class,ViewModelModule::class])
interface AppComponent : AndroidInjector<MainActivity>{
//    fun getAPIService():APIService
//    fun getRepo():MyRepo
//    fun getViewModelFactory():ViewModelFactory
}