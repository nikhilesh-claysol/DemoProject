package com.example.mvvmretrofitkt.model

import com.google.gson.annotations.SerializedName

data class Response123(

	@field:SerializedName("Response123")
	val response123: List<Response123Item>
)

data class Response123Item(

	@field:SerializedName("score")
	val score: Int,

	@field:SerializedName("word")
	val word: String,

	@field:SerializedName("tags")
	val tags: List<String>
)
