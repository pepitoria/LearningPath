package com.franciscogarciagarzon.learningpath.domain.model

import com.franciscogarciagarzon.learningpath.data.model.PokemonDao

data class PokemonDto(
    val defaultSprite: String,
    val name: String,
    val url: String
)


fun PokemonDao.toPokemonDto(): PokemonDto {
    return PokemonDto(
        defaultSprite = this.defaultSprite,
        name = this.name,
        url = this.url
    )
}