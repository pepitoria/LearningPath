package com.franciscogarciagarzon.learningpath.domain

import com.franciscogarciagarzon.learningpath.domain.model.PokemonDetailDto
import com.franciscogarciagarzon.learningpath.domain.model.PokemonListDto
import kotlinx.coroutines.flow.Flow

interface DatasourceAdapter {
    suspend fun getPokemonList(): Flow<PokemonListDto>
    suspend fun getPokemonDetail(id: String): Flow<PokemonDetailDto>
}