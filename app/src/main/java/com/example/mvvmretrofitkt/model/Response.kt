package com.example.mvvmretrofitkt.model

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("operation")
	val operation: Operation? = null
)

data class DetailsItem(

	@field:SerializedName("technician")
	val technician: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("user")
	val user: String? = null,

	@field:SerializedName("account")
	val account: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class Operation(

	@field:SerializedName("result")
	val result: Result? = null,

	@field:SerializedName("details")
	val details: List<DetailsItem?>? = null
)

data class Result(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
