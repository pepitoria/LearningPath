package com.franciscogarciagarzon.learningpath.domain.model

import com.franciscogarciagarzon.learningpath.data.model.PokemonDetailDao

data class PokemonDetailDto(
    val baseExperience: Int = -1,
    val height: Int = -1,
    val name: String = "",
    val sprites: SpritesDto = SpritesDto(),
    val stats: StatsDto = StatsDto(),
    val weight: Int = -1,
    val types: List<String> = emptyList()
)

fun PokemonDetailDao.toPokemonDetailDto(): PokemonDetailDto {
    return PokemonDetailDto(
        baseExperience = this.baseExperience,
        height = this.height,
        name = this.name,
        weight = this.weight,
        types = this.types,
        sprites = this.sprites.toSpritesDto(),
        stats = this.stats.toStatsDto()
    )
}