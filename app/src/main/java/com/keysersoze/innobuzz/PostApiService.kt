package com.keysersoze.innobuzz

import retrofit2.Call
import retrofit2.http.GET

interface PostApiService {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
}
