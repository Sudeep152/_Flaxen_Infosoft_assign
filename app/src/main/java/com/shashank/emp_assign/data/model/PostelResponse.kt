package com.shashank.emp_assign.data.model

data class PostelResponse(
    val country: String,
    val country_abbreviation: String,
    val places: List<Place>,
    val post_code: String
)