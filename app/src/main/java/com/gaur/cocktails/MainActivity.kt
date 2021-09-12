package com.gaur.cocktails

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gaur.cocktails.presentation.Screen
import com.gaur.cocktails.presentation.drink_details.DrinkDetailsScreen
import com.gaur.cocktails.presentation.drink_list.DrinkListScreen
import com.gaur.cocktails.presentation.ui.theme.CocktailsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            Scaffold() {
                CocktailsTheme {
                    val navController: NavController = rememberNavController()

                    NavHost(
                        navController = navController as NavHostController,
                        startDestination = Screen.DrinkListScreen.route
                    ) {
                        composable(Screen.DrinkListScreen.route) {
                            Surface(color = MaterialTheme.colors.background) {
                                DrinkListScreen(navController = navController)
                            }
                        }
                        composable(Screen.DrinkDetailsScreen.route + "/{drinkId}") {

                            Surface(color = MaterialTheme.colors.background) {
                                DrinkDetailsScreen()
                            }

                        }
                    }

                }
            }


        }
    }
}

