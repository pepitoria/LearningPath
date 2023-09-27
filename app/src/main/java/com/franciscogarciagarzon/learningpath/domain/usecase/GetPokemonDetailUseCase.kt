package com.franciscogarciagarzon.learningpath.domain.usecase

import com.franciscogarciagarzon.learningpath.data.MockDataSource
import com.franciscogarciagarzon.learningpath.domain.DatasourceAdapter
import com.franciscogarciagarzon.learningpath.domain.model.PokemonDetailDto
import com.franciscogarciagarzon.learningpath.domain.model.toPokemonDetailDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetPokemonDetailUseCase {
    private val datasource: DatasourceAdapter = MockDataSource()

    suspend operator fun invoke(pokemonName: String): Flow<PokemonDetailDto> = datasource.getPokemonDetail(id = pokemonName).map { pokemonDetail ->
        pokemonDetail.toPokemonDetailDto()
    }

}