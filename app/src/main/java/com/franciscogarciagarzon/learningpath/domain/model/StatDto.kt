package com.franciscogarciagarzon.learningpath.domain.model

import android.util.Log
import com.franciscogarciagarzon.learningpath.data.mock.model.StatDao

data class StatDto(val name: String = "", val value: Int = -1)


fun StatDao.toStatDto(): StatDto {
    Log.d("StatDto", "stat: $this")

    return StatDto(
        name = this.name,
        value = this.value
    )
}
