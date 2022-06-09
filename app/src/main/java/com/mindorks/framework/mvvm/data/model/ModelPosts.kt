package com.mindorks.framework.mvvm.data.model

import com.squareup.moshi.Json

data class ModelPosts(
    @Json(name = "userId")
    val userId: Int = 0,
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "title")
    val title: String = "",
    @Json(name = "body")
    val body: String = ""
)
