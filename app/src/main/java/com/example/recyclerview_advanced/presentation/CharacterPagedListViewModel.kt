package com.example.recyclerview_advanced.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CharacterPagedListViewModel : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    val filterEnabled = MutableStateFlow(false)

   // val pagedCharacter: Flow<PagingData<Character1>> = Pager(
   val pagedCharacter: Flow<PagingData<com.example.recyclerview_advanced.api.Character>> = Pager(
        config = PagingConfig(pageSize = 20),
        pagingSourceFactory = {
            CharacterPagingSource()
        }
    ).flow.cachedIn(viewModelScope)

}
