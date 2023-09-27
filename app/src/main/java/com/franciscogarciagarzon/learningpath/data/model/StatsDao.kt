package com.franciscogarciagarzon.learningpath.data.model

data class StatsDao(
    val attack: StatDao = StatDao(),
    val defense: StatDao = StatDao(),
    val hp: StatDao = StatDao(),
    val specialAttack: StatDao = StatDao(),
    val specialDefense: StatDao = StatDao(),
    val speed: StatDao = StatDao(),
)