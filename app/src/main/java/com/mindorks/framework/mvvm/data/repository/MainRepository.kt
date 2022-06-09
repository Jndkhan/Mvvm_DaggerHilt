package com.mindorks.framework.mvvm.data.repository

import com.mindorks.framework.mvvm.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getPosts() =  apiHelper.getPosts()
    suspend fun getComments() = apiHelper.getComments()
    suspend fun getPhotos() = apiHelper.getPhotos()
}