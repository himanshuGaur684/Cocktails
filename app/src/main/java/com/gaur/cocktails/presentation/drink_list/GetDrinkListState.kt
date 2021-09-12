package com.gaur.cocktails.presentation.drink_list

import com.gaur.cocktails.domain.model.Drink

data class GetDrinkListState(
    val isLoading: Boolean = false,
    val data: List<Drink> = emptyList(),
    val error: String? = ""

)