package com.keysersoze.innobuzz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel() {
    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> get() = _posts

    fun fetchPosts() {
        val service = RetrofitClient.create()
        service.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    _posts.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                println("Unable to fetch posts!")
            }
        })
    }
}
