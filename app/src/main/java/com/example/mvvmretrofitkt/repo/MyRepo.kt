package com.example.mvvmretrofitkt.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mvvmretrofitkt.di.DaggerSingleton.Companion.daggerAppComponent
import com.example.mvvmretrofitkt.model.WordModel
import com.example.mvvmretrofitkt.network.APIService
import com.google.gson.Gson
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
    private var allWordList: MutableLiveData<ArrayList<WordModel>> = MutableLiveData()
    @Inject
    lateinit var apiService: APIService
    fun callAPI(searchWord: String): MutableLiveData<ArrayList<WordModel>> {
        var wordModelList: ArrayList<WordModel> = ArrayList();
        if (daggerAppComponent != null) {
            apiService = daggerAppComponent.getAPIService()
        }
        var call: Call<List<WordModel>> =
                apiService.getWords(searchWord)

        call.enqueue(object : Callback<List<WordModel>> {
            override fun onResponse(call: Call<List<WordModel>>, response: Response<List<WordModel>>) {
                if (response.isSuccessful) {
                    try {
////                        Log.d("x23", "onResponse: " + response)
//                        val gson: Gson = Gson()
//                        val typeToken = object : TypeToken<List<WordModel>>() {}.type
                        //val wordModel = gson.fromJson<List<WordModel>>(response.body()?.string(),typeToken)
                        val wordModel = response.body()

//                        Log.d("x25", "onResponse: " + wordModel?.size)
                        if (wordModel != null) {
                            //wordModelList.clear()
                            wordModelList = wordModel as ArrayList<WordModel>
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

            override fun onFailure(call: Call<List<WordModel>>, t: Throwable) {
                allWordList.postValue(null)
            }


        })
        return allWordList

    }
}