package com.example.mvvmretrofitkt.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mvvmretrofitkt.di.DaggerAppComponent
import com.example.mvvmretrofitkt.di.DaggerSingleton.Companion.daggerAppComponent
import com.example.mvvmretrofitkt.di.RepoModule
import com.example.mvvmretrofitkt.di.RetrofitModule
import com.example.mvvmretrofitkt.model.WordModelItem

import com.example.mvvmretrofitkt.repo.MyRepo
import javax.inject.Inject

class WordListViewModel(application: Application) : AndroidViewModel(application) {
    @Inject
    lateinit var repo:MyRepo
    fun loadData(searchWord:String):MutableLiveData<ArrayList<WordModelItem>>{
        Log.d("x21", "loadData: ")
        if (daggerAppComponent != null) {
            Log.d("x23", "loadData: ")
            repo = daggerAppComponent.getRepo()
        }
        return repo.callAPI(searchWord)
    }


}