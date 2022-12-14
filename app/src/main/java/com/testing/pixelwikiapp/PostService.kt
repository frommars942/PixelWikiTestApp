package com.testing.pixelwikiapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {
    @GET("/posts/{id}")
    fun getById(@Path("id") id: Int): Call<PostResponse>
}