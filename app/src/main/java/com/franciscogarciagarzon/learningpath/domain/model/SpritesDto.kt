package com.franciscogarciagarzon.learningpath.domain.model

import com.franciscogarciagarzon.learningpath.data.model.SpritesDao

data class SpritesDto(
    val backDefault: String = "",
    val backFemale: String? = null,
    val backShiny: String = "",
    val backShinyFemale: String? = null,
    val frontDefault: String = "",
    val frontFemale: String? = null,
    val frontShiny: String = "",
    val frontShinyFemale: String? = null,
)

fun SpritesDao.toSpritesDto(): SpritesDto {
    return SpritesDto(
        backDefault = this.backDefault,
        backFemale = this.backFemale,
        backShiny = this.backShiny,
        backShinyFemale = this.backShinyFemale,
        frontDefault = this.frontDefault,
        frontFemale = this.frontFemale,
        frontShiny = this.frontShiny,
        frontShinyFemale = this.frontShinyFemale
    )
}