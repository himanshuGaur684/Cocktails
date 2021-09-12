package com.gaur.cocktails.presentation.drink_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gaur.cocktails.R
import com.gaur.cocktails.presentation.drink_details.components.IngredientsAndMeasures
import com.gaur.cocktails.presentation.drink_details.components.Tags
import com.gaur.cocktails.presentation.ui.NetworkImage

@Composable
fun DrinkDetailsScreen(viewModel: DrinkDetailsViewModel = hiltViewModel()) {

    val state = viewModel.drinkDetailsState.value

    Column(
        modifier = Modifier.verticalScroll(
            enabled = true,
            reverseScrolling = false,
            state = ScrollState(0)
        )
    ) {

        state.drink?.let {
            val image =
                NetworkImage(
                    url = state.drink.strDrinkThumb.toString(),
                    d = R.drawable.drink_placeholder
                )
            image.value?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = "Drink Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp),
                    contentScale = ContentScale.FillBounds
                )
            }

            Row(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = it.strDrink.toString(),
                    style = TextStyle(
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 28.sp

                    ),

                    )

                Text(
                    text = "\t(${it.strAlcoholic.toString()})",
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(top = 8.dp)
                )
            }



            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = it.strGlass.toString(),
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(8.dp)
                )
                Tags(tags = it.strTags)

            }




            Text(text = it.strInstructions.toString(), modifier = Modifier.padding(8.dp))

            Text(
                text = "Ingredients used to make it ",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp),
                modifier = Modifier.padding(8.dp)
            )


            IngredientsAndMeasures(ingredients = it.strIngredient1, measures = it.strMeasure1)
            IngredientsAndMeasures(ingredients = it.strIngredient2, measures = it.strMeasure2)
            IngredientsAndMeasures(ingredients = it.strIngredient3, measures = it.strMeasure3)
            IngredientsAndMeasures(ingredients = it.strIngredient4, measures = it.strMeasure4)
            IngredientsAndMeasures(ingredients = it.strIngredient5, measures = it.strMeasure5)
            IngredientsAndMeasures(ingredients = it.strIngredient6, measures = it.strMeasure6)
            IngredientsAndMeasures(ingredients = it.strIngredient7, measures = it.strMeasure7)
            IngredientsAndMeasures(ingredients = it.strIngredient8, measures = it.strMeasure8)
            IngredientsAndMeasures(ingredients = it.strIngredient9, measures = it.strMeasure9)
            IngredientsAndMeasures(ingredients = it.strIngredient10, measures = it.strMeasure10)
            IngredientsAndMeasures(ingredients = it.strIngredient11, measures = it.strMeasure11)
            IngredientsAndMeasures(ingredients = it.strIngredient12, measures = it.strMeasure12)
            IngredientsAndMeasures(ingredients = it.strIngredient13, measures = it.strMeasure13)
            IngredientsAndMeasures(ingredients = it.strIngredient14, measures = it.strMeasure14)
            IngredientsAndMeasures(ingredients = it.strIngredient15, measures = it.strMeasure15)


        }

    }
    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if (!state.error.isNullOrBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = state.error.toString() ?: "Please Check your Internet Connection",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }


}