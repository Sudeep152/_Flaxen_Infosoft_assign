package com.shashank.emp_assign.data.repository

import com.shashank.emp_assign.data.Instance.InstanceClient
import com.shashank.emp_assign.data.model.Place

import com.shashank.emp_assign.data.model.PostelResponse
import retrofit2.Response

class Repository {

    suspend fun getAllData(postal_code:String) : Response<PostelResponse> =
       InstanceClient.api.getPostalData(postal_code)


}