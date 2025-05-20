package com.example.planetapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planetapp.models.Planet
import com.example.planetapp.models.planetList
import com.example.planetapp.ui.components.TopAppBarWithMenu
import com.example.planetapp.ui.components.planetListItem


class HomeViewModel : ViewModel(){
    val recentSearches = mutableStateListOf<Planet>()
}

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    onPlanetSelected : (Planet) -> Unit,
    onSettingsClick : () -> Unit,
    onHelpClick : () -> Unit
){
    var searchQuery by remember { mutableStateOf("") }
    var filteredPlanets = remember(searchQuery) {
        planetList.filter {
            it.name.contains(searchQuery, ignoreCase = true)
        }
    }

    val recentSearches = remember { mutableStateListOf<Planet>() }
    val homeViewModel: HomeViewModel = viewModel()

    Scaffold (
        topBar = {
            TopAppBarWithMenu(
                onSettingsClick = onSettingsClick,
                onHelpClick = onHelpClick
            )
        }
    ){
        innerPadding ->
        Column (modifier = Modifier.padding(innerPadding)){
            TextField(
                value = searchQuery,
                onValueChange = {searchQuery = it},
                label = { Text("Pesquisar") },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )


            //isso daqui é massa que só oh :)
            Spacer(modifier = Modifier.height(16.dp))

            LazyRow (modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp) ) {



                items(homeViewModel.recentSearches){
                    planet ->
                    Button(onClick = {onPlanetSelected(planet)}) {
                        Text(planet.name)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn (
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                items(filteredPlanets) {
                    planet ->
                    planetListItem(
                        planet = planet,
                        onPlanetSelected = {
                            selectedPlanet ->
                            if (!homeViewModel.recentSearches.contains(selectedPlanet)){
                                homeViewModel.recentSearches.add(0, selectedPlanet)
                            }
                            onPlanetSelected(selectedPlanet)
                        },
                        onFavoriteToggle = {
                            favoritePlanet ->
                            favoritePlanet.isFavorite = !favoritePlanet.isFavorite
                        }
                    )
                }
            }
        }
    }
}
