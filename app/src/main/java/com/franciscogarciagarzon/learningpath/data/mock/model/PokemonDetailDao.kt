package com.franciscogarciagarzon.learningpath.data.mock.model

data class PokemonDetailDao(
    val baseExperience: Int = -1,
    val height: Int = -1,
    val name: String = "",
    val sprites: SpritesDao = SpritesDao(),
    val stats: StatsDao = StatsDao(),
    val weight: Int = -1,
    val types: List<String> = emptyList()
)