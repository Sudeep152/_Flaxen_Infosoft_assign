package com.shashank.emp_assign.data.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shashank.emp_assign.data.model.Place
import com.shashank.emp_assign.data.model.PostelResponse
import com.shashank.emp_assign.data.repository.Repository
import com.shashank.emp_assign.data.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel (val repository: Repository): ViewModel() {

    val myresponse : MutableLiveData<Resource<PostelResponse>> = MutableLiveData()
    fun  getAllData(postal_code:String) =
        viewModelScope.launch {
          myresponse.postValue(Resource.Loading())
            val response = repository.getAllData(postal_code)
            myresponse.postValue(handlerSearchingPostalResponse(response))

        }
    private  fun handlerSearchingPostalResponse(response: Response<PostelResponse>): Resource<PostelResponse>{
        if(response.isSuccessful){
            response.body()?.let { resultResponse ->
                return  Resource.Success(resultResponse)
            }
        }
        return  Resource.Error(response.message())
    }



}