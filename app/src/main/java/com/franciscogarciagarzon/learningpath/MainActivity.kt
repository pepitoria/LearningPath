package com.franciscogarciagarzon.learningpath

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.franciscogarciagarzon.learningpath.ui.theme.LearningPathTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningPathTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    PokemonList()
                }
            }
        }
    }
}

@Composable
fun PokemonList() {
    LazyColumn {
        val pokemonList = MockDataSource().getPokemonList()
        items(pokemonList.pokemons.size) { index ->
            Row(
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val pokemon = pokemonList.pokemons[index]

                // AsyncImage in its simplest form (just feeding it url + content description) didn't keep the images size when scrolling back and forth
                // this way we find the sizes don't change for our current tasks

                // you might want to research "Compose, State, and Recomposition"

                val painter = remember {
                    mutableStateOf<AsyncImagePainter?>(null)
                }

                painter.value = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(
                            pokemon.defaultSprite.ifEmpty { R.drawable.pokeball_icon }
                        )
                        .crossfade(true)
                        .placeholder(R.drawable.pokeball_icon)
                        .size(coil.size.Size.ORIGINAL)
                        .build()
                )

                Image(
                    painter = painter.value as AsyncImagePainter,
                    contentDescription = pokemon.name,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxHeight(0.8f)
                        .aspectRatio(1f)
                        .width(IntrinsicSize.Min)

                )

                Text(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .fillMaxWidth(),
                    text = pokemon.name.capitalize(locale = Locale.current),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

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