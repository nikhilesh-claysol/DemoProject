package com.example.mvvmretrofitkt.di

import com.example.mvvmretrofitkt.repo.MyRepo
import dagger.Module
import dagger.Provides

@Module
class RepoModule {
    @Provides
    fun repo():MyRepo {
        return MyRepo()
    }
}