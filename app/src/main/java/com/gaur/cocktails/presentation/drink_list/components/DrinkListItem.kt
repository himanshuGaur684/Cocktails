package com.gaur.cocktails.presentation.drink_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.gaur.cocktails.R
import com.gaur.cocktails.domain.model.Drink
import com.gaur.cocktails.presentation.ui.NetworkImage

@Composable
fun DrinkListItem(drink: Drink, onItemCLick: (Drink) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentHeight(), elevation = 12.dp

    ) {
        Column(modifier = Modifier
            .background(Color.LightGray)
            .clickable { onItemCLick(drink) }
            .padding(8.dp)) {
            drink.strDrinkThumb.let { drinkThumb ->
                val image = NetworkImage(url = drinkThumb, d = R.drawable.drink_placeholder).value
                drink.strDrinkThumb.let {
                    image?.let { img ->
                        Image(
                            bitmap = img.asImageBitmap(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                            contentScale = ContentScale.FillBounds,
                            contentDescription = "Drink Thumbnail"
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
                    .fillMaxWidth(),

                ) {
                Text(
                    text = drink.strDrink.toString(),
                    style = MaterialTheme.typography.body1,
                    maxLines = 2,
                )
                Text(
                    text = drink.strAlcoholic.toString(),
                    style = MaterialTheme.typography.caption, fontStyle = FontStyle.Italic
                )


            }


        }

    }


}




