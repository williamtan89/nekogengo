package com.nekogengo.services

import retrofit2.http.GET

interface GitDbServices {
    @GET("williamtan89/nekogengo/main/gitdb/test.json")
    suspend fun getTestJson(): Map<String, String>
}