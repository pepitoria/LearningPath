package com.franciscogarciagarzon.learningpath.domain.usecase

import com.franciscogarciagarzon.learningpath.data.remote.RemoteDataSource
import com.franciscogarciagarzon.learningpath.domain.DatasourceAdapter
import com.franciscogarciagarzon.learningpath.domain.model.PokemonListDto
import kotlinx.coroutines.flow.Flow

class GetPokemonListUseCase {
    private val datasource: DatasourceAdapter = RemoteDataSource()
    suspend operator fun invoke(): Flow<PokemonListDto> = datasource.getPokemonList()

}