package com.gaur.cocktails.presentation.drink_details.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun IngredientsAndMeasures(ingredients: String?, measures: String?) {
    if (ingredients.isNullOrBlank() || measures.isNullOrBlank()) return
    Row(modifier = Modifier.padding(8.dp)) {
        Text(text = ingredients)
        Text(text = ": ")
        Spacer(modifier = Modifier.padding(start = 8.dp))
        Text(text = measures)
    }

}