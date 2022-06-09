package com.mindorks.framework.mvvm.data.model

import com.squareup.moshi.Json

data class ModelComments(
    @Json(name = "postId")
    val postId: Int = 0,
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "name")
    val name: String = "",
    @Json(name = "email")
    val email: String = "",
    @Json(name = "body")
    val body: String = ""
)
