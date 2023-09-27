package com.franciscogarciagarzon.learningpath.domain

import com.franciscogarciagarzon.learningpath.data.model.PokemonDetailDao
import com.franciscogarciagarzon.learningpath.data.model.PokemonListDao
import kotlinx.coroutines.flow.Flow

interface DatasourceAdapter {
    suspend fun getPokemonList(): Flow<PokemonListDao>
    suspend fun getPokemonDetail(id: String): Flow<PokemonDetailDao>
}