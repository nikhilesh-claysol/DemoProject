package com.example.mvvmretrofitkt.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mvvmretrofitkt.di.AppComponent
import com.example.mvvmretrofitkt.di.DaggerAppComponent
import com.example.mvvmretrofitkt.di.DaggerSingleton.Companion.daggerAppComponent
import com.example.mvvmretrofitkt.di.RetrofitModule

import com.example.mvvmretrofitkt.model.WordModelItem

import com.example.mvvmretrofitkt.network.APIService
import com.example.mvvmretrofitkt.network.RetroInstance
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class MyRepo() {
    private var allWordList: MutableLiveData<ArrayList<WordModelItem>> = MutableLiveData()
    @Inject
    lateinit var apiService: APIService
    fun callAPI(searchWord: String): MutableLiveData<ArrayList<WordModelItem>> {
        var wordModelList: ArrayList<WordModelItem> = ArrayList();
        if (daggerAppComponent != null) {
            Log.d("x25", "callAPI: ")
            apiService = daggerAppComponent.getAPIService()
        }
        var call: Call<ResponseBody> =
                apiService.getWords(searchWord)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    try {
                        Log.d("x23", "onResponse: " + response.body()?.string())
                        val gson: Gson = Gson()
                        val typeToken = object : TypeToken<List<WordModelItem>>() {}.type
                        val wordModel = gson.fromJson<List<WordModelItem>>(response.body()?.string(),typeToken)

                        Log.d("x25", "onResponse: " + wordModel?.size)
                        if (wordModel != null) {
                            wordModelList.clear()
                            // wordModelList.addAll(wordModel)
                            Log.d("x25", "onResponse: ")
                            allWordList.postValue(wordModelList)
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace();
                    } catch (e: IOException) {
                        e.printStackTrace();
                    } catch (e: IllegalStateException) {
                        e.printStackTrace()
                    } catch (e: JsonSyntaxException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                allWordList.postValue(null)
            }

        })
        return allWordList

    }
}