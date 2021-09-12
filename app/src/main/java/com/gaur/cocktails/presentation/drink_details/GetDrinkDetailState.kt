package com.gaur.cocktails.presentation.drink_details

import com.gaur.cocktails.domain.model.DrinkDetails

class GetDrinkDetailState(
    val isLoading: Boolean = false,
    val drink: DrinkDetails? = null,
    val error: String? = ""
) {
}