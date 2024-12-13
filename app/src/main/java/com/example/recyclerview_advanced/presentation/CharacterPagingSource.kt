package com.example.recyclerview_advanced.presentation

import androidx.paging.PagingSource
import androidx.paging.PagingState

class CharacterPagingSource : PagingSource<Int, com.example.recyclerview_advanced.api.Character>() {

     // val getCharacterPagedListRepositoryUseCase = GetCharacterPagedListRepositoryUseCase()
    val characterPagedListRepository = CharacterPagedListRepository()
    override fun getRefreshKey(state: PagingState<Int, com.example.recyclerview_advanced.api.Character>): Int? = FIRST_PAGE
/*
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character1> {
        try {
            val page = params.key ?: FIRST_PAGE
            val response = getCharacterPagedListRepositoryUseCase.executeCharacter(page)
            val character = response//?: emptyList() // проверка на null и присвоение пустого списка, если значение null
            Log.d("CharacterPagingSource", "CharacterPagingSource character =${character}")
            return LoadResult.Page(
                data = character,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (character.isEmpty()) null else page + 1 // добавление проверки на пустой список перед установкой следующего ключа
            )

        } catch (e: Exception) {
            return LoadResult.Error(e)

        }

        Log.d("CharacterPagingSource", "CharacterPagingSource load params =${params}")
    }
*/
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, com.example.recyclerview_advanced.api.Character> {
        val page = params.key ?: FIRST_PAGE
        return kotlin.runCatching {
            characterPagedListRepository.getCharacterList(page).results
        }.fold(
            onSuccess = {
                LoadResult.Page(
                    data = it,
                    prevKey = null,
                    nextKey = if (it.isEmpty()) null else page + 1
                )
            },
            onFailure = { LoadResult.Error(it) }
        )
    }

    private companion object {
        private val FIRST_PAGE = 1
    }
}


