package com.gaur.cocktails.presentation

sealed class Screen(val route: String) {
    object DrinkListScreen : Screen(route = "drink_list_screen")
    object DrinkDetailsScreen : Screen(route = "drink_details_screen")
}