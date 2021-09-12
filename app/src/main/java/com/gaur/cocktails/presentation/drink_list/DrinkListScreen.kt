package com.gaur.cocktails.presentation.drink_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gaur.cocktails.common.Constants
import com.gaur.cocktails.presentation.Screen
import com.gaur.cocktails.presentation.drink_list.components.DrinkListItem

@ExperimentalFoundationApi
@Composable
fun DrinkListScreen(
    navController: NavController,
    viewModel: DrinkListViewModel = hiltViewModel(),

    ) {

    val state = viewModel.drinkListState.value
    val searchQuery = remember { mutableStateOf(TextFieldValue()) }

    Column() {
        TextField(value = searchQuery.value, onValueChange = {
            searchQuery.value = it
            viewModel.savedStateHandle.set(Constants.SEARCH_QUERY, it.text)
        }, placeholder = { Text("enter drink name") },

            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .background(Color.White)
                .wrapContentHeight(),

            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Text,
            ),
            textStyle = TextStyle.Default,
            trailingIcon = {
                androidx.compose.material.Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "search"
                )
            }

        )



        Box(modifier = Modifier.fillMaxWidth()) {
            LazyVerticalGrid(cells = GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
                items(state.data) { drink ->
                    DrinkListItem(drink = drink, onItemCLick = {
                        navController.navigate(Screen.DrinkDetailsScreen.route + "/${drink.idDrink}")
                    })
                }
            }
        }
    }




    if (!state.error.isNullOrBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = state.error, textAlign = TextAlign.Center, modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }

    }


    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }


}