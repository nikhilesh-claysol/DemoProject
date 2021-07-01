package com.example.mvvmretrofitkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmretrofitkt.adapter.WordListAdapter
import com.example.mvvmretrofitkt.databinding.ActivityMainBinding
import com.example.mvvmretrofitkt.model.WordModelItem

import com.example.mvvmretrofitkt.viewmodel.WordListViewModel

class MainActivity : AppCompatActivity() {
    lateinit var wordListViewModel:WordListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        wordListViewModel = WordListViewModel(application);
        val linearLayout = LinearLayoutManager(this)
        var wordModelList: ArrayList<WordModelItem> = ArrayList()
        binding.recyclerView.layoutManager = linearLayout
        val wordListAdapter = WordListAdapter(this,wordModelList);
        binding.recyclerView.adapter = wordListAdapter
        binding.etSearch.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                var searchWord = v?.text.toString();
                searchWord = searchWord.replace(' ', '+')
                searchForWord(searchWord)
                true
            }
            else false
        }
        wordListViewModel.loadData("App").observe(this, {
            if(it != null){
                wordModelList = it
//                wordListAdapter.updateList(wordModelList)
            }
        })
    }
    private fun searchForWord(text:String){
        Log.d("x21", "searchForWord: ")
        wordListViewModel.loadData(text)
    }
}