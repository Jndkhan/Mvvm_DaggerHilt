package com.mindorks.framework.mvvm.ui.main.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.mindorks.framework.mvvm.data.model.ModelComments
import com.mindorks.framework.mvvm.data.model.ModelPhotos
import com.mindorks.framework.mvvm.data.model.ModelPosts
import com.mindorks.framework.mvvm.data.repository.MainRepository
import com.mindorks.framework.mvvm.utils.NetworkHelper
import com.mindorks.framework.mvvm.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _posts = MutableLiveData<Resource<List<ModelPosts>>>()
    val posts: LiveData<Resource<List<ModelPosts>>>
        get() = _posts

    private val _comments = MutableLiveData<Resource<List<ModelComments>>>()
    val comments: LiveData<Resource<List<ModelComments>>>
        get() = _comments

    private val _photos = MutableLiveData<Resource<List<ModelPhotos>>>()
    val photos: LiveData<Resource<List<ModelPhotos>>>
        get() = _photos

    init {
        fetchPosts()
        fetchComments()
        fetchPhotos()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            _posts.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getPosts().let {
                    if (it.isSuccessful) {
                        _posts.postValue(Resource.success(it.body()))
                    } else _posts.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _posts.postValue(Resource.error("No internet connection", null))
        }
    }

    private fun fetchComments() {
        viewModelScope.launch {
            _comments.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getComments().let {
                    if (it.isSuccessful) {
                        _comments.postValue(Resource.success(it.body()))
                    } else {
                        _comments.postValue(Resource.error(it.errorBody().toString(), null))
                    }
                }
            } else {
                _comments.postValue(Resource.error("No Internet connection", null))
            }
        }
    }

    private fun fetchPhotos() {
        viewModelScope.launch {
            _photos.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getPhotos().let {
                    if (it.isSuccessful) {
                        _photos.postValue(Resource.success(it.body()))
                    } else {
                        _photos.postValue(Resource.error(it.errorBody().toString(), null))
                    }
                }
            }
            else{
                _photos.postValue(Resource.error("No internet connection", null))
            }

        }
    }

}