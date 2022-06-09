package com.mindorks.framework.mvvm.data.api

import com.mindorks.framework.mvvm.data.model.ModelComments
import com.mindorks.framework.mvvm.data.model.ModelPhotos
import com.mindorks.framework.mvvm.data.model.ModelPosts
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): Response<List<ModelPosts>>
    @GET("comments")
    suspend fun getComments(): Response<List<ModelComments>>
    @GET("photos")
    suspend fun getPhotos():Response<List<ModelPhotos>>

}