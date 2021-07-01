package com.example.mvvmretrofitkt.network

import com.example.mvvmretrofitkt.model.WordModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

public interface APIService {
    @GET("words")
    fun getWords(@Query("ml") words:String) : Call<List<WordModel>>
}