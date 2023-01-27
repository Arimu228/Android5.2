package com.example.android52.data

import com.example.android52.data.model.Characters
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository {

    fun getCharacters(
        page: Int,
        returnOnSuccess: (Characters) -> Unit,
        returnOnFailure: (String) -> Unit
    ) {
        RetroFitClient.api.getCharacters(2).enqueue(object : Callback<Characters> {
            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                if (response.isSuccessful) returnOnSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<Characters>, t: Throwable) {
                returnOnFailure(t.message ?: "Unknown Error")
            }
        })
    }
}

//git init   - создание локального git репозиотрия

// git commit -m "Second commit"

// git status - печатает текущие изменения в проекте

// git add .  - проиндексировать все изменения

// git push -u origin master