package com.franciscogarciagarzon.learningpath.ui.screens.pokemondetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.franciscogarciagarzon.learningpath.data.MockDataSource
import com.franciscogarciagarzon.learningpath.data.model.PokemonDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class PokemonDetailViewModel : ViewModel() {
    private val dataSource = MockDataSource()
    private var _pokemonDetail = MutableStateFlow<PokemonDetail>(PokemonDetail())
    val pokemonDetail = _pokemonDetail
    fun getPokemonDetail(pokemonId: String) {
        viewModelScope.launch {
            Log.d("PokemonDetailViewModel", "getPokemonDetail launched with id: $pokemonId")

            dataSource.getPokemonDetail(pokemonId)
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    Log.e("PokemonDetailViewModel", "exception: ${e.message}", e)
                }
                .collect() { pokemonDetail ->
                    _pokemonDetail.value = pokemonDetail
                }
        }
    }

}