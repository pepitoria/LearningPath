package com.franciscogarciagarzon.learningpath.domain.usecase

import com.franciscogarciagarzon.learningpath.data.remote.RemoteDataSource
import com.franciscogarciagarzon.learningpath.domain.DatasourceAdapter
import com.franciscogarciagarzon.learningpath.domain.model.PokemonDetailDto
import kotlinx.coroutines.flow.Flow

class GetPokemonDetailUseCase {
    private val datasource: DatasourceAdapter = RemoteDataSource()

    suspend operator fun invoke(pokemonName: String): Flow<PokemonDetailDto> = datasource.getPokemonDetail(id = pokemonName)

}