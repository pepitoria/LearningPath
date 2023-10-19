package com.franciscogarciagarzon.learningpath.ui.screens.navigation

sealed class Screen(val route: String) {
    object PokemonList : Screen("main")
    object PokemonDetail : Screen("detail/{pokemonName}") {
        fun createRoute(pokemonName: String) = "detail/$pokemonName"
    }
}
