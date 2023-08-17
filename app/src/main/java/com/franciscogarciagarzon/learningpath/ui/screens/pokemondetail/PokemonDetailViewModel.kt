package com.franciscogarciagarzon.learningpath.ui.screens.pokemondetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.franciscogarciagarzon.learningpath.data.MockDataSource
import com.franciscogarciagarzon.learningpath.data.model.PokemonDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PokemonDetailViewModel : ViewModel() {
    private val dataSource = MockDataSource()
    private var _uiState = MutableStateFlow<PokemonDetail>(PokemonDetail())
    val uiState = _uiState
    fun getPokemonDetail(pokemonId: String) {
        viewModelScope.launch {
            Log.d("PokemonDetailViewModel", "getPokemonDetail launched with id: $pokemonId")
            _uiState.value = dataSource.getPokemonDetail(pokemonId)
        }
    }

}