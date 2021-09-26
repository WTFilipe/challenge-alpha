package com.filipeoliveira.hurbchallenge.data.remote

import com.filipeoliveira.hurbchallenge.data.remote.model.HotelRequestResponse
import retrofit2.Call
import retrofit2.http.GET

interface HotelService {
    @GET("/endpoint/desejado")
    fun getUpComingMovies(): Call<HotelRequestResponse>
}