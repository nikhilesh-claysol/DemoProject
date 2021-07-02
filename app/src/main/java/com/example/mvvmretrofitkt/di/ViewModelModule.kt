package com.example.mvvmretrofitkt.di

import androidx.lifecycle.ViewModel
import com.example.mvvmretrofitkt.viewmodel.WordListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(WordListViewModel::class)
    abstract fun provideWordViewModel(wordListViewModel: WordListViewModel):ViewModel
}