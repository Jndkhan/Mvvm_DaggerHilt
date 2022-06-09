package com.mindorks.framework.mvvm.data.api

import com.mindorks.framework.mvvm.data.model.ModelComments
import com.mindorks.framework.mvvm.data.model.ModelPhotos
import com.mindorks.framework.mvvm.data.model.ModelPosts
import retrofit2.Response

interface ApiHelper {
    suspend fun getPosts(): Response<List<ModelPosts>>
    suspend fun getComments(): Response<List<ModelComments>>
    suspend fun getPhotos():Response<List<ModelPhotos>>
}