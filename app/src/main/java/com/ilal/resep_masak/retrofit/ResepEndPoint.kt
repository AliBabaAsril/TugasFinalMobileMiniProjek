package com.ilal.resep_masak.retrofit

import com.ilal.resep_masak.model.ResepModel
import retrofit2.Call
import retrofit2.http.GET

interface ResepEndPoint {

    @GET("api/recipes")
    fun getDataResep(): Call<ResepModel>

}