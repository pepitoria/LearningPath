package com.franciscogarciagarzon.learningpath.ui.screens.pokemonlist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.franciscogarciagarzon.learningpath.data.MockDataSource
import com.franciscogarciagarzon.learningpath.data.model.PokemonList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PokemonListViewModel : ViewModel() {
    private val dataSource = MockDataSource()

    private val _uiState: MutableStateFlow<PokemonList> = MutableStateFlow<PokemonList>(PokemonList(emptyList()))
    val uiState = _uiState
    fun getPokemonList() {
        viewModelScope.launch {
            Log.d("PokemonListViewModel", "getPokemonList launched")
            _uiState.value = dataSource.getPokemonList()
        }
    }
}