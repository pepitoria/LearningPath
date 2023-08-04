package com.franciscogarciagarzon.learningpath

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.franciscogarciagarzon.learningpath.ui.screens.pokemondetail.PokemonDetail
import com.franciscogarciagarzon.learningpath.ui.screens.pokemonlist.PokemonList
import com.franciscogarciagarzon.learningpath.ui.theme.LearningPathTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main") {
                composable("main") {
                    PokemonList(navController)
                }
                composable(
                    route = "detail/{pokemonId}",
                    arguments = listOf(navArgument("pokemonId") { type = NavType.StringType })
                )
                { backStackEntry ->
                    val pokemonId = backStackEntry.arguments?.getString("pokemonId")
                    requireNotNull(pokemonId)
                    PokemonDetail(pokemonId)
                }

            }

//            PokemonList()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    LearningPathTheme {
//        PokemonList()
    }
}