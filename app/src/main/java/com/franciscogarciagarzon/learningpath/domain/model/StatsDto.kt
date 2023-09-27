package com.franciscogarciagarzon.learningpath.domain.model

import android.util.Log
import com.franciscogarciagarzon.learningpath.data.model.StatsDao

data class StatsDto(
    val attack: StatDto = StatDto(),
    val defense: StatDto = StatDto(),
    val hp: StatDto = StatDto(),
    val specialAttack: StatDto = StatDto(),
    val specialDefense: StatDto = StatDto(),
    val speed: StatDto = StatDto(),
)


fun StatsDao.toStatsDto(): StatsDto {
    Log.d("StatsDto", "stats: $this")

    return StatsDto(
        attack = this.attack.toStatDto(),
        defense = this.defense.toStatDto(),
        hp = this.hp.toStatDto(),
        specialAttack = this.specialAttack.toStatDto(),
        specialDefense = this.specialDefense.toStatDto(),
        speed = this.speed.toStatDto()
    )
}