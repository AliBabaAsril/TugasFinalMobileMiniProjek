package com.ilal.resep_masak.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ResepClient {
    val base_url = "https://masak-apa.tomorisakura.vercel.app/"

    val INSTANCE : ResepEndPoint by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ResepEndPoint::class.java)
    }
}