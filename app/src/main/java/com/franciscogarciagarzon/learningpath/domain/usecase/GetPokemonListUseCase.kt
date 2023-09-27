package com.franciscogarciagarzon.learningpath.domain.usecase

import com.franciscogarciagarzon.learningpath.data.MockDataSource
import com.franciscogarciagarzon.learningpath.domain.DatasourceAdapter
import com.franciscogarciagarzon.learningpath.domain.model.PokemonListDto
import com.franciscogarciagarzon.learningpath.domain.model.toPokemonListDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetPokemonListUseCase {
    val datasource: DatasourceAdapter = MockDataSource()
    suspend operator fun invoke(): Flow<PokemonListDto> = datasource.getPokemonList().map { list -> list.toPokemonListDto() }

}