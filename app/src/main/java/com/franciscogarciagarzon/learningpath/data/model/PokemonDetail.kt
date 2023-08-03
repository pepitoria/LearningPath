package com.franciscogarciagarzon.learningpath.data.model

data class PokemonDetail(
    val baseExperience: Int,
    val height: Int,
    val name: String,
    val sprites: Sprites,
    val stats: Stats,
    val weight: Int,
    val types: List<String>
)