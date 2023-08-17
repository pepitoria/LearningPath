package com.franciscogarciagarzon.learningpath.ui.screens.pokemondetail

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.franciscogarciagarzon.learningpath.ui.screens.navigation.TopNavBar
import com.franciscogarciagarzon.learningpath.ui.theme.LearningPathTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetail(id: String, navigateUp: () -> Unit = {}) {
    val viewModel = viewModel<PokemonDetailViewModel>()
    val pokemonDetail by viewModel.uiState.collectAsState()
    viewModel.getPokemonDetail(pokemonId = id)
    LearningPathTheme {
        Scaffold(
            topBar = {
                TopNavBar(
                    title = pokemonDetail.name,
                    modifier = Modifier,
                    upNavigation = navigateUp
                )
            },
            content = { innerPadding ->
                Log.d("PokemonDetailScreen", "Composable pokemonDetail: $pokemonDetail")
                if (pokemonDetail.name.isNotBlank()) {
                    // since we're using the _ugly hack_ of default "blank" pokemonDetail, we need to make sure we're not displaying those blanks
                    // this would be solved with a loading state (could be cool to use animations on said state, as short as it may be)
                    PokemonDetail(pokemonDetail, innerPadding)
                }
            }
        )

    }

}
