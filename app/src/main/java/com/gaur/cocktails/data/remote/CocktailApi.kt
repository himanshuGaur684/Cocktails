package com.gaur.cocktails.data.remote

import com.gaur.cocktails.data.remote.dto.DrinksDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailApi {


    @GET("api/json/v1/1/search.php")
    suspend fun getCocktailList(@Query("s") s: String): DrinksDTO


    @GET("api/json/v1/1/lookup.php")
    suspend fun getCocktailDetail(@Query("i") id: String): DrinksDTO

}