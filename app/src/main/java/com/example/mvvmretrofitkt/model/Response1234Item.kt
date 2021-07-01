package com.example.mvvmretrofitkt.model

import com.google.gson.annotations.SerializedName

data class Response1234Item(

	@field:SerializedName("score")
	val score: Int? = null,

	@field:SerializedName("word")
	val word: String? = null,

	@field:SerializedName("tags")
	val tags: List<String?>? = null
)