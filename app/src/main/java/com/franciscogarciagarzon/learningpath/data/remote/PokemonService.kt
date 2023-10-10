package com.franciscogarciagarzon.learningpath.data.remote

import com.franciscogarciagarzon.learningpath.data.remote.model.PokemonDetailDao
import com.franciscogarciagarzon.learningpath.data.remote.model.PokemonListDao
import kotlinx.coroutines.flow.Flow

interface PokemonService {
    fun getPokemonList(): Flow<PokemonListDao>
    fun getPokemonDetail(pokemonName: String): Flow<PokemonDetailDao>

}