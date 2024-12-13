//package com.example.recyclerview_advanced.domain
//
//import android.util.Log
//import com.example.recyclerview_advanced.entity.Character1
//import com.example.recyclerview_advanced.presentation.CharacterPagedListRepository
//
//


//class GetCharacterPagedListRepositoryUseCase {
//    private val characterPagedListRepository = CharacterPagedListRepository()
//    suspend fun executeCharacter(page: Int): List<Character1> {
//        Log.d("GetCharacterPagedListRepositoryUseCase", "GetCharacterPagedListRepositoryUseCase executeCharacter $page")
//        val getExecuteCharacter = characterPagedListRepository.getCharacterList(page)
//        Log.d("GetCharacterPagedListRepositoryUseCase", "GetCharacterPagedListRepositoryUseCase  val getExecuteCharacter ${getExecuteCharacter}")
//        return getExecuteCharacter
//    }
//}