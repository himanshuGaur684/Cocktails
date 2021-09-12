package com.gaur.cocktails.domain.repository

import com.gaur.cocktails.data.remote.dto.DrinksDTO

interface DrinkRepository {

    suspend fun getDrinkList(s: String): DrinksDTO

    suspend fun getDrinkDetails(id: String): DrinksDTO


}