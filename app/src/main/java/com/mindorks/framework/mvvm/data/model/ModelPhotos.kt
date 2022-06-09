package com.mindorks.framework.mvvm.data.model

import com.squareup.moshi.Json

data class ModelPhotos(
    @Json(name = "albumId")
    val albumId: Int = 0,
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "title")
    val title: String = "",
    @Json(name = "url")
    val url: String = "",
    @Json(name = "thumbnailUrl")
    val thumbnailUrl: String = ""
)
