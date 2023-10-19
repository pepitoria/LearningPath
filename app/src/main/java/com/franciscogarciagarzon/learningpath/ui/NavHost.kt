package com.franciscogarciagarzon.learningpath.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.franciscogarciagarzon.learningpath.ui.screens.navigation.Screen.PokemonDetail
import com.franciscogarciagarzon.learningpath.ui.screens.navigation.Screen.PokemonList
import com.franciscogarciagarzon.learningpath.ui.screens.pokemondetail.PokemonDetail
import com.franciscogarciagarzon.learningpath.ui.screens.pokemonlist.PokemonList

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = PokemonList.route,
    ) {
        composable(route = PokemonList.route) {
            PokemonListNavigator(navController = navController)
        }
        composable(route = PokemonDetail.route) {
            PokemonDetailNavigator(
                navController = navController,
                backStackEntry = it,
            )
        }
    }
}

@Composable
fun PokemonListNavigator(navController: NavHostController) {
    PokemonList(
        showPokemonDetail = { pokemonName ->
            Log.d("MainActivity", "navigation lambda showPokemonDetail ($pokemonName)")
            navController.navigate(
                route = PokemonDetail.createRoute(pokemonName),
            )
        },
        favNavigation = {
            navController.navigate(route = PokemonDetail.createRoute("charizard"))
        },
    )
}

@Composable
fun PokemonDetailNavigator(navController: NavHostController, backStackEntry: NavBackStackEntry) {
    val pokemonName = backStackEntry.arguments?.getString("pokemonName")
    requireNotNull(pokemonName)
    PokemonDetail(
        id = pokemonName,
        navigateUp = {
            navController.popBackStack()
        },
    )
}
