package com.franciscogarciagarzon.learningpath.ui.screens.pokemondetail

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.franciscogarciagarzon.learningpath.data.MockDataSource
import com.franciscogarciagarzon.learningpath.ui.screens.navigation.TopNavBar
import com.franciscogarciagarzon.learningpath.ui.theme.LearningPathTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetail(id: String, navigateUp: () -> Unit = {}) {
    val pokemonDetail = MockDataSource().getPokemonDetail(id)
    LearningPathTheme {
        Scaffold(
            topBar = {
                TopNavBar(
                    title = pokemonDetail.name,
                    modifier = Modifier,
                    upNavigation = navigateUp
                )
            },
            content = { innerPadding -> PokemonDetail(pokemonDetail, innerPadding) }
        )

    }

}


@Preview(showBackground = true)
@Composable
fun PokemonListPreview() {
    LearningPathTheme {
        PokemonDetail(id = "", {})
    }
}