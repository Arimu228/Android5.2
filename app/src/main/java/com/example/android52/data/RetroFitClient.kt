package com.example.android52.data


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetroFitClient {

    private val retroFit: Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val api = retroFit.create<RickAndMortyApi>()


}