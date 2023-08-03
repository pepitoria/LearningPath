package com.franciscogarciagarzon.learningpath

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.franciscogarciagarzon.learningpath.ui.screens.pokemonlist.PokemonList
import com.franciscogarciagarzon.learningpath.ui.theme.LearningPathTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonList()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    LearningPathTheme {
        PokemonList()
    }
}