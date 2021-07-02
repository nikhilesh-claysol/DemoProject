package com.example.mvvmretrofitkt.di

import com.example.mvvmretrofitkt.repo.MyRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {
    @Singleton
    @Provides
    fun repo():MyRepo {
        return MyRepo()
    }
}