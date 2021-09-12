package com.gaur.cocktails.presentation.drink_details.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Tags(tags: String?) {
    tags?.let {
        Card(
            modifier = Modifier.padding(8.dp),
            border = BorderStroke(1.dp, Color.Red),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = tags,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(8.dp)
            )
        }
    }


}