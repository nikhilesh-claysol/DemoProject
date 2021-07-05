package com.example.mvvmretrofitkt.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mvvmretrofitkt.Util.DaggerSingleton.Companion.daggerAppComponent

import com.example.mvvmretrofitkt.model.WordModel
import com.example.mvvmretrofitkt.repo.MyRepo
import javax.inject.Inject

class WordListViewModel @Inject constructor(var repo: MyRepo) : BaseViewModel() {
    fun loadData(searchWord:String):MutableLiveData<ArrayList<WordModel>>{
        return repo.callAPI(searchWord)
    }


}