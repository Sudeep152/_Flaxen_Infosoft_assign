package com.shashank.emp_assign.data.model

import com.google.gson.annotations.SerializedName

data class Place(
    @SerializedName("place name")var place_name: String,
    @SerializedName("longitude")var longitude: String,
    @SerializedName("state") var state:String,
    @SerializedName("state abbreviation")var state_abbreviation:String,
    @SerializedName("latitude")var latitude:String

)