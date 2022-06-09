package com.mindorks.framework.mvvm.data.api

import com.mindorks.framework.mvvm.data.model.ModelComments
import com.mindorks.framework.mvvm.data.model.ModelPhotos
import com.mindorks.framework.mvvm.data.model.ModelPosts
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun getPosts(): Response<List<ModelPosts>> {
        return apiService.getPosts()
    }
    override suspend fun getComments(): Response<List<ModelComments>> {
        return apiService.getComments()
    }
    override suspend fun getPhotos(): Response<List<ModelPhotos>> {
        return apiService.getPhotos()
    }
 }