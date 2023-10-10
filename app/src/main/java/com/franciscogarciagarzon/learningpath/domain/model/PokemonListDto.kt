package com.franciscogarciagarzon.learningpath.domain.model

import com.franciscogarciagarzon.learningpath.data.remote.model.PokemonListDao

data class PokemonListDto(
    val pokemons: List<PokemonDto>
)


fun PokemonListDao.toPokemonListDto(): PokemonListDto {
    return PokemonListDto(pokemons = this.results.map { pokemonDao -> pokemonDao.toPokemonDto() })
}



