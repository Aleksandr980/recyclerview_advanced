package com.example.recyclerview_advanced.presentation

import android.util.Log
import com.example.recyclerview_advanced.api.Response
import com.example.recyclerview_advanced.api.retrofit

class CharacterPagedListRepository {
    suspend fun getCharacterList(page: Int): Response {

        Log.d("CharacterPagedListRepository","CharacterPagedListRepository getCharacterList $page")
val response = retrofit.character(page)

        Log.d("CharacterPagedListRepository","CharacterPagedListRepository   return retrofit.character(page) ${response}")
        return response
    }
}