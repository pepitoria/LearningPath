package com.franciscogarciagarzon.learningpath.data.model

data class PokemonDetail(
    val baseExperience: Int = -1,
    val height: Int = -1,
    val name: String = "",
    val sprites: Sprites = Sprites(),
    val stats: Stats = Stats(),
    val weight: Int = -1,
    val types: List<String> = emptyList()
)