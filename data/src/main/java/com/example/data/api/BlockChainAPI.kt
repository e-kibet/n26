package com.example.data.api

import com.example.data.models.StatsResponse
import retrofit2.Response
import retrofit2.http.GET

interface BlockChainAPI {

    @GET("stats")
    suspend fun fetchStats(): Response<StatsResponse>
}