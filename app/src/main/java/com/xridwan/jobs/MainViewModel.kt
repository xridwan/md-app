package com.xridwan.jobs

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainViewModel: ViewModel() {

    fun login(username: String, password: String): LiveData<Response>{
        val login = MutableLiveData<Response>()
        viewModelScope.launch {
          try {
              val data = ApiConfig.getApiService().login(username, password)
              if (data.isSuccessful) login.value = data.body()
              else Log.e(TAG, "login: ${data.code()}")
          } catch (e: HttpException){
              Log.e(TAG, "login: ${e.localizedMessage}")
          }
        }
        return login
    }
}