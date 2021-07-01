package com.example.mvvmretrofitkt.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mvvmretrofitkt.di.DaggerSingleton.Companion.daggerAppComponent
import com.example.mvvmretrofitkt.model.WordModel
import com.example.mvvmretrofitkt.repo.MyRepo
import javax.inject.Inject

class WordListViewModel(application: Application) : AndroidViewModel(application) {
    @Inject
    lateinit var repo:MyRepo
    fun loadData(searchWord:String):MutableLiveData<ArrayList<WordModel>>{
        if (daggerAppComponent != null) {
            repo = daggerAppComponent.getRepo()
        }
        return repo.callAPI(searchWord)
    }


}