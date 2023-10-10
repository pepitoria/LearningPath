package com.franciscogarciagarzon.learningpath.domain.model

import com.franciscogarciagarzon.learningpath.data.remote.model.PokemonDetailDao
import com.franciscogarciagarzon.learningpath.data.remote.model.TypeDao

data class PokemonDetailDto(
    val baseExperience: Int = -1,
    val height: Int = -1,
    val name: String = "",
    val sprites: SpritesDto = SpritesDto(),
    val stats: StatsDto = StatsDto(),
    val weight: Int = -1,
    val types: List<String> = emptyList()
)


fun List<TypeDao>.toDomainTypes(): List<String> {
    val numberOfTypes = this.size
    val listOfTypes = mutableListOf<String>()
    listOfTypes.add(this.first().type.name)
    if (numberOfTypes > 1) {
        listOfTypes.add(this.last().type.name)
    }
    return listOfTypes
}

fun PokemonDetailDao.toPokemonDetailDto(): PokemonDetailDto {
    return PokemonDetailDto(
        baseExperience = this.baseExperience,
        height = this.height,
        name = this.name,
        weight = this.weight,
        types = this.types.toDomainTypes(),
        sprites = this.sprites.toSpritesDto(),
        stats = this.stats.toStatsDto()
    )
}