package com.franciscogarciagarzon.learningpath.ui.screens.pokemonlist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.franciscogarciagarzon.learningpath.data.MockDataSource
import com.franciscogarciagarzon.learningpath.data.model.PokemonList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class PokemonListViewModel : ViewModel() {
    private val dataSource = MockDataSource()

    private val _uiState: MutableStateFlow<PokemonList> = MutableStateFlow<PokemonList>(PokemonList(emptyList()))
    val uiState = _uiState
    fun getPokemonList() {
        viewModelScope.launch {
            Log.d("PokemonListViewModel", "getPokemonList launched")
            dataSource.getPokemonList()
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    Log.e("PokemonListViewModel", "exception: ${e.message}", e)
                }
                .collect() { pokemonList ->
                    _uiState.value = pokemonList
                }
        }
    }
}