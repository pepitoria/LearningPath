package com.franciscogarciagarzon.learningpath.ui.screens.pokemonlist

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.franciscogarciagarzon.learningpath.data.MockDataSource
import com.franciscogarciagarzon.learningpath.ui.theme.LearningPathTheme


@Composable
fun PokemonList(navController: NavController) {
    LearningPathTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            LazyColumn {
                val pokemonList = MockDataSource().getPokemonList()
                items(pokemonList.pokemons.size) { index ->
                    val pokemon = pokemonList.pokemons[index]
                    PokemonListElement(pokemon = pokemon, clickAction = {
                        Log.d("ListItem", "clicked on ${pokemon.name}")
                        navController.navigate("detail/${pokemon.name}")
                    })

                }

            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PokemonListPreview() {
    LearningPathTheme {
//        PokemonList()
    }
}