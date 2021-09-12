package com.gaur.cocktails.data.repository

import android.util.Log
import com.gaur.cocktails.common.TAG
import com.gaur.cocktails.data.remote.CocktailApi
import com.gaur.cocktails.data.remote.dto.DrinksDTO
import com.gaur.cocktails.domain.repository.DrinkRepository

class DrinkRepository_Impl(private val api: CocktailApi) : DrinkRepository {
    override suspend fun getDrinkList(s: String): DrinksDTO {
        val r = api.getCocktailList(s)
        Log.d(TAG, "Drink list repository: ${api.getCocktailList(s)}")
        return r
    }

    override suspend fun getDrinkDetails(id: String): DrinksDTO {
        return api.getCocktailDetail(id)
    }
}