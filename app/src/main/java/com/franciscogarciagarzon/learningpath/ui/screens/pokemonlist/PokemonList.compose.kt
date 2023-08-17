package com.franciscogarciagarzon.learningpath.ui.screens.pokemonlist

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.franciscogarciagarzon.learningpath.data.MockDataSource
import com.franciscogarciagarzon.learningpath.data.model.PokemonList

@Composable
fun PokemonList(
    pokemonList: PokemonList,
    innerPadding: PaddingValues,
    showPokemonDetail: (pokemonName: String) -> Unit) {
    LazyColumn(modifier = androidx.compose.ui.Modifier.padding(innerPadding)) {
//        val pokemonList = MockDataSource().getPokemonList()
        items(pokemonList.pokemons.size) { index ->
            val pokemon = pokemonList.pokemons[index]
            PokemonListElement(pokemon = pokemon, clickAction = {
                Log.d("ListItem", "clicked on ${pokemon.name}")
                showPokemonDetail(pokemon.name)
            })

        }

    }
}