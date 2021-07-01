package com.example.mvvmretrofitkt

import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmretrofitkt.adapter.WordListAdapter
import com.example.mvvmretrofitkt.databinding.ActivityMainBinding
import com.example.mvvmretrofitkt.model.WordModel
import com.example.mvvmretrofitkt.viewmodel.WordListViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var wordListViewModel:WordListViewModel
    private lateinit var wordModelList: ArrayList<WordModel>
    private lateinit var wordListAdapter :WordListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        wordListViewModel = WordListViewModel(application);
        val linearLayout = LinearLayoutManager(this)
        wordModelList= ArrayList()
        binding.recyclerView.layoutManager = linearLayout
        wordListAdapter = WordListAdapter(this,wordModelList);
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
//        wordListViewModel.loadData("App").observe(this, {
//            if (it != null) {
//                wordModelList = it
//                wordListAdapter.updateList(wordModelList)
//                Log.d("x27", "onCreate: ")
//            }
//        })
    }
    private fun searchForWord(text:String){
        Log.d("x21", "searchForWord: ")
        wordListViewModel.loadData(text).observe(this, {
            if (it != null) {
                wordModelList = it
                wordListAdapter.updateList(wordModelList)
                Log.d("x27", "onCreate: ")
            }
        })
    }
}