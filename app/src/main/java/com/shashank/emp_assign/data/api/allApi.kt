package com.shashank.emp_assign.data.api

import com.shashank.emp_assign.data.model.Place
import com.shashank.emp_assign.data.model.PostelResponse
import retrofit2.Response
import retrofit2.http.*

interface allApi {


    @GET("in/{postal-code}")
    suspend fun getPostalData(
      @Path("postal-code")  postal_code:String
    ):Response<PostelResponse>
}