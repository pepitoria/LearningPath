package com.franciscogarciagarzon.learningpath.ui.screens.pokemonlist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.franciscogarciagarzon.learningpath.ui.screens.navigation.BottomNavBar
import com.franciscogarciagarzon.learningpath.ui.theme.LearningPathTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun PokemonList(
    showPokemonDetail: (pokemonName: String) -> Unit = {},
    homeNavigation: () -> Unit = {},
    favNavigation: () -> Unit = {}
) {

    LearningPathTheme {
        Scaffold(

            content = { innerPadding ->
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    PokemonList(
                        innerPadding = innerPadding,
                        showPokemonDetail = showPokemonDetail
                    )
                }
            },
            bottomBar = {
                BottomNavBar(
                    homeNavigation = homeNavigation,
                    favNavigation = favNavigation,
                )
            },
        )


        // A surface container using the 'background' color from the theme

    }

}


@Preview(showBackground = true)
@Composable
fun PokemonListPreview() {
    LearningPathTheme {
//        PokemonList()
    }
}