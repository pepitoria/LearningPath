package com.franciscogarciagarzon.learningpath.domain.model

import com.franciscogarciagarzon.learningpath.data.model.PokemonListDao

data class PokemonListDto(
    val pokemons: List<PokemonDto>
)


fun PokemonListDao.toPokemonListDto(): PokemonListDto {
    return PokemonListDto(pokemons = this.pokemons.map { pokemonDao -> pokemonDao.toPokemonDto() })
}




