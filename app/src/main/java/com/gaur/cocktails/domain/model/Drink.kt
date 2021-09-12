package com.gaur.cocktails.domain.model

data class Drink(
    val idDrink: String,
    val strAlcoholic: String,
    val strCategory: String,
    val strCreativeCommonsConfirmed: String?,
    val strDrink: String?,
    val strDrinkAlternate: String?,
    val strDrinkThumb: String,
    val strGlass: String?,
    val strIBA: String?
)