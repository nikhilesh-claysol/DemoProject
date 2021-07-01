package com.example.mvvmretrofitkt.di

class DaggerSingleton {
    companion object{
        val daggerAppComponent: AppComponent? = DaggerAppComponent.builder()
            .repoModule(RepoModule())
            .retrofitModule(RetrofitModule())
            .build()
        }
}



