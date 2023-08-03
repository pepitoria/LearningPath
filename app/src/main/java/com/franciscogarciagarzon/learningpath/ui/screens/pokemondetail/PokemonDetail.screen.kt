package com.franciscogarciagarzon.learningpath.ui.screens.pokemondetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.franciscogarciagarzon.learningpath.R
import com.franciscogarciagarzon.learningpath.data.MockDataSource
import com.franciscogarciagarzon.learningpath.data.model.PokemonDetail
import com.franciscogarciagarzon.learningpath.ui.screens.components.BoldLabel
import com.franciscogarciagarzon.learningpath.ui.screens.components.BoldLabel30
import com.franciscogarciagarzon.learningpath.ui.screens.components.BoldLabel40
import com.franciscogarciagarzon.learningpath.ui.screens.components.RegularLabel
import com.franciscogarciagarzon.learningpath.ui.screens.components.RemoteImage
import com.franciscogarciagarzon.learningpath.ui.theme.LearningPathTheme
import com.franciscogarciagarzon.learningpath.ui.theme.Purple40
import com.franciscogarciagarzon.learningpath.ui.theme.Purple80


@Composable
fun PokemonDetail(pokemonDetail: PokemonDetail) {
    LearningPathTheme {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(state = scrollState)
                .background(Purple80),

            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .background(Purple40),
            ) {
//                AsyncImage(
//                    model = pokemonDetail.sprites.frontDefault,
//                    contentDescription = pokemonDetail.name,
//                    placeholder = painterResource(id = R.drawable.pokeball_icon),
//                )
                RemoteImage(
                    imageUrl = pokemonDetail.sprites.frontDefault,
                    placeholderResource = R.drawable.pokeball_icon,
                    errorResource = R.drawable.pokeball_icon,
                    contentDescription = pokemonDetail.name
                )
            }


            BoldLabel40(text = pokemonDetail.name, textAlignment = TextAlign.Center)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                val types = pokemonDetail.types
                BoldLabel(text = "Type(s): ")
                RegularLabel(text = pokemonDetail.types.first())
                if (types.size > 1) {
                    BoldLabel(text = " / ")
                    RegularLabel(text = pokemonDetail.types.last())
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                // type/s
                val types = pokemonDetail.types
                Row(
                    modifier = Modifier
                        .weight(0.5f),
                    horizontalArrangement = Arrangement.Start
                ) {
                    BoldLabel(text = "Weight: ")
                    RegularLabel(text = "${pokemonDetail.weight / 10} Kg")
                }
                // height & weigt
                Row(
                    modifier = Modifier
                        .weight(0.5f),
                    horizontalArrangement = Arrangement.End
                ) {
                    BoldLabel(text = "Height")
                    RegularLabel(text = "${pokemonDetail.height * 10} cm")
                }
            }
            // stats
            val stats = pokemonDetail.stats
            BoldLabel30(
                text = "Stats",
                textAlignment = TextAlign.Center,
                modifier = Modifier.padding(top = 10.dp)
            )

            StatRow(stat = stats.hp)
            StatRow(stat = stats.attack)
            StatRow(stat = stats.defense)
            StatRow(stat = stats.speed)
            StatRow(stat = stats.specialAttack)
            StatRow(stat = stats.specialDefense)

            Row(modifier = Modifier.height(30.dp)) {

            }
        }

    }

}


@Preview(showBackground = true)
@Composable
fun PokemonListPreview() {
    LearningPathTheme {
        PokemonDetail(
            pokemonDetail = MockDataSource().getPokemonDetail("")
        )
    }
}