package com.example.mvvmretrofitkt.model

import com.google.gson.annotations.SerializedName


data class WordModelItem(
    @SerializedName("score")
    val score: Int?,
    @SerializedName("tags")
    val tags: List<String>?,
    @SerializedName("word")
    val word: String?
)