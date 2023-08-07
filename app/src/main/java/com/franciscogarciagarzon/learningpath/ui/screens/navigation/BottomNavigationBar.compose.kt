package com.franciscogarciagarzon.learningpath.ui.screens.navigation

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.franciscogarciagarzon.learningpath.ui.theme.Purple40

@Preview
@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    homeNavigation: () -> Unit = {},
    favNavigation: () -> Unit = {},
) {
    NavigationBar(
        modifier = modifier,
        containerColor = Purple40,
    ) {
        NavigationBarItem(
            selected = true,
            onClick = {
                Log.d("NavigationBar", "Home clicked")
                homeNavigation()
            },
            label = { Text("Home") },
            icon = { Icon(Icons.Default.Home, "Home") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {
                Log.d("NavigationBar", "FAV clicked")
                favNavigation()
            },
            label = { Text("Fav") },
            icon = { Icon(Icons.Default.Favorite, "Fav") }
        )
    }

}

