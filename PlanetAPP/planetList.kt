package com.example.planetapp.models

import com.example.planetapp.R

val planetList = listOf(
    Planet(
        id = 1,
        name = "Earth",
        type = "Terrestrial",
        galaxy = "Milky Way",
        distanceFromSun = "149.6 million km",
        diameter = "12,742 km",
        characteristics = "Supports life, has water and atmosphere.",
        imageRes = R.drawable.terra
    ),
    Planet(
        id = 2,
        name = "Mars",
        type = "Terrestrial",
        galaxy = "Milky Way",
        distanceFromSun = "227.9 million km",
        diameter = "6,779 km",
        characteristics = "Known as the Red Planet, has the largest volcano in the solar system.",
        imageRes = R.drawable.marte
    ),
    Planet(
        id = 3,
        name = "Jupiter",
        type = "Gas Giant",
        galaxy = "Milky Way",
        distanceFromSun = "778.5 million km",
        diameter = "139,820 km",
        characteristics = "Largest planet in the solar system, known for its Great Red Spot.",
        imageRes = R.drawable.jupiter
    ),
    Planet(
        id = 4,
        name = "Saturn",
        type = "Gas Giant",
        galaxy = "Milky Way",
        distanceFromSun = "1.4 billion km",
        diameter = "116,460 km",
        characteristics = "Famous for its prominent ring system.",
        imageRes = R.drawable.saturno
    ),
    Planet(
        id = 5,
        name = "Venus",
        type = "Terrestrial",
        galaxy = "Milky Way",
        distanceFromSun = "108.2 million km",
        diameter = "12,104 km",
        characteristics = "Hottest planet in the solar system due to a thick atmosphere of CO2.",
        imageRes = R.drawable.venus
    ),
    Planet(
        id = 6,
        name = "Mercury",
        type = "Terrestrial",
        galaxy = "Milky Way",
        distanceFromSun = "57.9 million km",
        diameter = "4,880 km",
        characteristics = "Closest planet to the Sun, has extreme temperature fluctuations.",
        imageRes = R.drawable.mercurio
    ),
    Planet(
        id = 7,
        name = "Uranus",
        type = "Ice Giant",
        galaxy = "Milky Way",
        distanceFromSun = "2.87 billion km",
        diameter = "50,724 km",
        characteristics = "Has a tilted axis, leading to extreme seasonal changes.",
        imageRes = R.drawable.urano
    ),
    Planet(
        id = 8,
        name = "Neptune",
        type = "Ice Giant",
        galaxy = "Milky Way",
        distanceFromSun = "4.5 billion km",
        diameter = "49,244 km",
        characteristics = "Known for its deep blue color and the fastest winds in the solar system.",
        imageRes = R.drawable.netuno
    ),
    Planet(
        id = 9,
        name = "Pluto",
        type = "Dwarf Planet",
        galaxy = "Milky Way",
        distanceFromSun = "5.9 billion km",
        diameter = "2,376 km",
        characteristics = "Once considered the ninth planet, now classified as a dwarf planet.",
        imageRes = R.drawable.plutao
    ),
)
