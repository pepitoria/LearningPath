package com.franciscogarciagarzon.learningpath.domain.model

import com.franciscogarciagarzon.learningpath.data.remote.model.ExternalStatDao

data class StatsDto(
    val attack: StatDto = StatDto(),
    val defense: StatDto = StatDto(),
    val hp: StatDto = StatDto(),
    val specialAttack: StatDto = StatDto(),
    val specialDefense: StatDto = StatDto(),
    val speed: StatDto = StatDto(),
)


fun List<ExternalStatDao>.toStatsDto(): StatsDto {
    var attack: StatDto = StatDto()
    var defense: StatDto = StatDto()
    var hp: StatDto = StatDto()
    var specialAttack: StatDto = StatDto()
    var specialDefense: StatDto = StatDto()
    var speed: StatDto = StatDto()

    for (stat in this) {
        when (stat.stat.name) {
            "attack" -> attack = StatDto(name = stat.stat.name, value = stat.baseStat)
            "defense" -> defense = StatDto(name = stat.stat.name, value = stat.baseStat)
            "hp" -> hp = StatDto(name = stat.stat.name, value = stat.baseStat)
            "special-attack" -> specialAttack = StatDto(name = "Sp. Attack", value = stat.baseStat)
            "special-defense" -> specialDefense = StatDto(name = "Sp. Defense", value = stat.baseStat)
            "speed" -> speed = StatDto(name = stat.stat.name, value = stat.baseStat)
        }
    }

    return com.franciscogarciagarzon.learningpath.domain.model.StatsDto(
        attack = attack,
        defense = defense,
        hp = hp,
        specialAttack = specialAttack,
        specialDefense = specialDefense,
        speed = speed
    )

}