package com.example.mvvmretrofitkt.Util

import com.example.mvvmretrofitkt.di.AppComponent
import com.example.mvvmretrofitkt.di.DaggerAppComponent

import com.example.mvvmretrofitkt.di.RepoModule
import com.example.mvvmretrofitkt.di.RetrofitModule

class DaggerSingleton {
    companion object{
        val daggerAppComponent: AppComponent? = DaggerAppComponent.builder()
            .repoModule(RepoModule())
            .retrofitModule(RetrofitModule())
            .build()
        }

}



