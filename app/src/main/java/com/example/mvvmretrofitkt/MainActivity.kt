package com.example.mvvmretrofitkt

import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmretrofitkt.Util.DaggerSingleton.Companion.daggerAppComponent
import com.example.mvvmretrofitkt.adapter.WordListAdapter
import com.example.mvvmretrofitkt.databinding.ActivityMainBinding
import com.example.mvvmretrofitkt.di.ViewModelFactory
//import com.example.mvvmretrofitkt.di.ViewModelFactory
import com.example.mvvmretrofitkt.model.WordModel
import com.example.mvvmretrofitkt.viewmodel.WordListViewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity() ,HasAndroidInjector{
    private lateinit var wordListViewModel:WordListViewModel
    private lateinit var wordModelList: ArrayList<WordModel>
    private lateinit var wordListAdapter :WordListAdapter
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        daggerAppComponent?.inject(this)
        wordListViewModel = ViewModelProvider(this, viewModelFactory).get(WordListViewModel::class.java)
        val linearLayout = LinearLayoutManager(this)
        wordModelList= ArrayList()
        binding.recyclerView.layoutManager = linearLayout
        wordListAdapter = WordListAdapter(this,wordModelList);
        binding.recyclerView.adapter = wordListAdapter
        binding.etSearch.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                var searchWord = v?.text.toString();
                searchWord = searchWord.replace(' ', '+')
                searchForWord(searchWord)
                true
            }
            else false
        }

    }
    private fun searchForWord(text:String){
        wordListViewModel.loadData(text).observe(this, {
            if (it != null) {
                wordModelList = it
                wordListAdapter.updateList(wordModelList)
            }
        })
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}