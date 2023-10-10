package com.franciscogarciagarzon.learningpath.data.remote.model


import com.google.gson.annotations.SerializedName

data class TypeDao(
    @SerializedName("slot")
    val slot: Int,
    @SerializedName("type")
    val type: TypeX
)