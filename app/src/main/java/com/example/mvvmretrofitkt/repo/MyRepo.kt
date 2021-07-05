package com.example.mvvmretrofitkt.repo

import androidx.lifecycle.MutableLiveData
import com.example.mvvmretrofitkt.model.WordModel
import com.example.mvvmretrofitkt.network.APIService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MyRepo  @Inject constructor(var apiService: APIService) {
    private var allWordList: MutableLiveData<ArrayList<WordModel>> = MutableLiveData()

    fun callAPI(searchWord: String): MutableLiveData<ArrayList<WordModel>> {
        apiService.getWords(searchWord)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    allWordList.postValue(it)
                }
        return allWordList
//        var wordModelList: ArrayList<WordModel>
//        val call: Call<List<WordModel>> =
//                apiService.getWords(searchWord)
//
//        call.enqueue(object : Callback<List<WordModel>> {
//            override fun onResponse(call: Call<List<WordModel>>, response: Response<List<WordModel>>) {
//                if (response.isSuccessful) {
//                    try {
//                        Log.d("x23", "onResponse: $response")
//                        val wordModel = response.body()
//
//                        if (wordModel != null) {
//                            wordModelList = wordModel as ArrayList<WordModel>
//                            Log.d("x25", "onResponse: ")
//                            allWordList.postValue(wordModelList)
//                        }
//                    } catch (e: JSONException) {
//                        allWordList.postValue(null)
//                        e.printStackTrace();
//                    } catch (e: IOException) {
//                        allWordList.postValue(null)
//                        e.printStackTrace();
//                    } catch (e: IllegalStateException) {
//                        allWordList.postValue(null)
//                        e.printStackTrace()
//                    } catch (e: JsonSyntaxException) {
//                        allWordList.postValue(null)
//                        e.printStackTrace()
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<List<WordModel>>, t: Throwable) {
//                allWordList.postValue(null)
//            }
//
//
//        })
//        return allWordList

    }
}