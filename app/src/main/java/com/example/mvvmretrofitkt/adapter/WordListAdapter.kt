package com.example.mvvmretrofitkt.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmretrofitkt.R
import com.example.mvvmretrofitkt.databinding.RowLayoutBinding
import com.example.mvvmretrofitkt.model.WordModel


class WordListAdapter(val context:Context, var wordModels:ArrayList<WordModel>) :
     RecyclerView.Adapter<WordListAdapter.ViewHolder>() {

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val view :View = LayoutInflater.from(context).inflate(R.layout.row_layout ,parent,false)
         return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wordModel :WordModel = wordModels.get(position)
        holder.tvScore?.text = wordModel.score.toString()
        holder.tvWords?.text = wordModel.word
    }

    override fun getItemCount(): Int {
        return wordModels.size
    }
      class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
          var tvScore:TextView? = itemView.findViewById(R.id.score)
          var tvWords:TextView? = itemView.findViewById(R.id.word)
      }

      fun updateList(wordModels:ArrayList<WordModel>){
          this.wordModels = wordModels
          notifyDataSetChanged()
      }
}