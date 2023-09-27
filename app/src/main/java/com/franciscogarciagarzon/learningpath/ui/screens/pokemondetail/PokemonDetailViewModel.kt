package com.franciscogarciagarzon.learningpath.ui.screens.pokemondetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.franciscogarciagarzon.learningpath.domain.model.PokemonDetailDto
import com.franciscogarciagarzon.learningpath.domain.usecase.GetPokemonDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class PokemonDetailViewModel : ViewModel() {
    private val getPokemonDetailUseCase = GetPokemonDetailUseCase()

    private var _uiState = MutableStateFlow<PokemonDetailDto>(PokemonDetailDto())
    val uiState = _uiState
    fun getPokemonDetail(pokemonId: String) {
        viewModelScope.launch {
            Log.d("PokemonDetailViewModel", "getPokemonDetail launched with id: $pokemonId")
            getPokemonDetailUseCase.invoke(pokemonName = pokemonId)
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    Log.e("PokemonDetailViewModel", "exception: ${e.message}", e)
                }
                .collect() { pokemonDetail ->
                    _uiState.value = pokemonDetail
                }
        }
    }

}