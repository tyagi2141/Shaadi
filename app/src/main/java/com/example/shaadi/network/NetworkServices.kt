package com.example.shaadi.network

import com.example.shaadi.model.HomeResponse
import io.reactivex.Single
import retrofit2.http.*

interface NetworkServices {


    @GET("api/")
    fun getApiResponse(
        @Query("results") results: Int?
    ): Single<HomeResponse>

}
