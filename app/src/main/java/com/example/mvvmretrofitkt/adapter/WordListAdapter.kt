package com.example.mvvmretrofitkt.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmretrofitkt.R
import com.example.mvvmretrofitkt.databinding.RowLayoutBinding

import com.example.mvvmretrofitkt.model.WordModelItem


class WordListAdapter(val context:Context, var wordModels:ArrayList<WordModelItem>) :
     RecyclerView.Adapter<WordListAdapter.ViewHolder>() {

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val view :View = LayoutInflater.from(context).inflate(R.layout.row_layout ,parent,false)
         return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val wordModel :WordModel = wordModels.get(0)
//        val wordModelItem: WordModelItem? = wordModel.response?.get(position)
//        holder.bindingUtil.score.text = wordModelItem?.score.toString()
//        holder.bindingUtil.word.text = wordModelItem?.word
    }

    override fun getItemCount(): Int {
        return wordModels.size
    }
      class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val bindingUtil:RowLayoutBinding = DataBindingUtil.setContentView(itemView.context as Activity, R.layout.row_layout)

     }
//      fun updateList(wordModels:ArrayList<WordModel>){
//          this.wordModels = wordModels
//          notifyDataSetChanged()
//      }
}