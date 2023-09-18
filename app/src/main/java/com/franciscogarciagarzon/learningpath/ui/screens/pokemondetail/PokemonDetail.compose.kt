package com.franciscogarciagarzon.learningpath.ui.screens.pokemondetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.unit.dp
import com.franciscogarciagarzon.learningpath.R
import com.franciscogarciagarzon.learningpath.data.model.PokemonDetail
import com.franciscogarciagarzon.learningpath.ui.screens.components.BoldLabel
import com.franciscogarciagarzon.learningpath.ui.screens.components.BoldLabel30
import com.franciscogarciagarzon.learningpath.ui.screens.components.RegularLabel
import com.franciscogarciagarzon.learningpath.ui.screens.components.RemoteImage
import com.franciscogarciagarzon.learningpath.ui.theme.Purple40
import com.franciscogarciagarzon.learningpath.ui.theme.Purple80

@Composable
fun PokemonDetail(
    pokemonDetail: PokemonDetail,
    innerPadding: PaddingValues,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(innerPadding)
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

            RemoteImage(
                imageUrl = pokemonDetail.sprites.frontDefault,
                placeholderResource = R.drawable.pokeball_icon,
                errorResource = R.drawable.ic_pokeball_blank,
                contentDescription = pokemonDetail.name
            )
        }

        Column(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
        ) {


//            BoldLabel40(text = pokemonDetail.name, textAlignment = TextAlign.Center)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                val types = pokemonDetail.types
                BoldLabel(text = "Type(s): ")
                RegularLabel(text = pokemonDetail.types.firstOrNull() ?: "")
                if (types.size > 1) {
                    BoldLabel(text = " / ")
                    RegularLabel(text = pokemonDetail.types.last())
                }
            }
            Row(
                modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .fillMaxWidth(),
            ) {
                // weight & height
                Row(
                    modifier = Modifier
                        .weight(0.5f),
                    horizontalArrangement = Arrangement.Start
                ) {
                    BoldLabel(text = "Weight: ")
                    RegularLabel(text = "${pokemonDetail.weight / 10} Kg")
                }

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