package com.franciscogarciagarzon.learningpath.data

import com.franciscogarciagarzon.learningpath.data.model.Pokemon
import com.franciscogarciagarzon.learningpath.data.model.PokemonDetail
import com.franciscogarciagarzon.learningpath.data.model.PokemonList
import com.franciscogarciagarzon.learningpath.data.model.Sprites
import com.franciscogarciagarzon.learningpath.data.model.Stat
import com.franciscogarciagarzon.learningpath.data.model.Stats

class MockDataSource {

    private val pokemonList = PokemonList(
        pokemons = listOf(
            Pokemon(name = "bulbasaur", defaultSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png", url = "https://pokeapi.co/api/v2/pokemon/1/"),
            Pokemon(name = "ivysaur", defaultSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png", url = "https://pokeapi.co/api/v2/pokemon/2/"),
            Pokemon(name = "venusaur", defaultSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png", url = "https://pokeapi.co/api/v2/pokemon/3/"),
            Pokemon(name = "charmander", defaultSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png", url = "https://pokeapi.co/api/v2/pokemon/4/"),
            Pokemon(name = "charmeleon", defaultSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png", url = "https://pokeapi.co/api/v2/pokemon/5/"),
            Pokemon(name = "charizard", defaultSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png", url = "https://pokeapi.co/api/v2/pokemon/6/"),
            Pokemon(name = "squirtle", defaultSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png", url = "https://pokeapi.co/api/v2/pokemon/7/"),
            Pokemon(name = "wartortle", defaultSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/8.png", url = "https://pokeapi.co/api/v2/pokemon/8/"),
            Pokemon(name = "blastoise", defaultSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png", url = "https://pokeapi.co/api/v2/pokemon/9/"),
            Pokemon(name = "caterpie", defaultSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/10.png", url = "https://pokeapi.co/api/v2/pokemon/10/"),
            Pokemon(name = "metapod", defaultSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/11.png", url = "https://pokeapi.co/api/v2/pokemon/11/"),
            Pokemon(name = "butterfree", defaultSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/12.png", url = "https://pokeapi.co/api/v2/pokemon/12/"),
            Pokemon(name = "weedle", defaultSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/13.png", url = "https://pokeapi.co/api/v2/pokemon/13/"),
            Pokemon(name = "kakuna", defaultSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/14.png", url = "https://pokeapi.co/api/v2/pokemon/14/"),
            Pokemon(name = "beedrill", defaultSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/15.png", url = "https://pokeapi.co/api/v2/pokemon/15/"),
            Pokemon(name = "pidgey", defaultSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/16.png", url = "https://pokeapi.co/api/v2/pokemon/16/"),
            Pokemon(name = "pidgeotto", defaultSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/17.png", url = "https://pokeapi.co/api/v2/pokemon/17/"),
            Pokemon(name = "pidgeot", defaultSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/18.png", url = "https://pokeapi.co/api/v2/pokemon/18/"),
            Pokemon(name = "rattata", defaultSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/19.png", url = "https://pokeapi.co/api/v2/pokemon/19/"),
            Pokemon(name = "raticate", defaultSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/20.png", url = "https://pokeapi.co/api/v2/pokemon/20/"),

            )
    )


    private val pokemonDetail = PokemonDetail(
        name = "Ditto",
        baseExperience = 101,
        height = 3,
        weight = 40,
        stats = Stats(
            hp = Stat(name = "hp", 75),
            attack = Stat(name = "attack", value = 34),
            defense = Stat(name = "defense", value = 42),
            specialAttack = Stat(name = "Sp. Attack", 26),
            specialDefense = Stat(name = "Sp. Defense", value = 45),
            speed = Stat("speed", value = 37)
        ),
        sprites = Sprites(
            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png",
            backDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/132.png",
            frontFemale = null,
            backFemale = null,
            frontShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/132.png",
            backShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/132.png",
            frontShinyFemale = null,
            backShinyFemale = null,
        ),
        types = listOf("normal")
    )

    suspend fun getPokemonList(): PokemonList = this.pokemonList

    suspend fun getPokemonDetail(id: String): PokemonDetail = this.pokemonDetail
}