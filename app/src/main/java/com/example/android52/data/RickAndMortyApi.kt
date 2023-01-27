package com.example.android52.data

import com.example.android52.data.model.Characters
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET(" /api/character/")
    fun getCharacters(
        @Query("page")page:Int
    ): Call<Characters>

    @GET ("/search")
    fun google(
        @Path("search") ser: String,
        @Query("oq") oq: String,
        @Query("oqq") oqq: String,
        @Query("owq") owq: String,
    )

}