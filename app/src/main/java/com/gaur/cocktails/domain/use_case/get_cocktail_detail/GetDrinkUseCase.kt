package com.gaur.cocktails.domain.use_case.get_cocktail_detail

import com.gaur.cocktails.common.Result
import com.gaur.cocktails.data.remote.dto.toDrinkDetails
import com.gaur.cocktails.domain.model.DrinkDetails
import com.gaur.cocktails.domain.repository.DrinkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetDrinkUseCase @Inject constructor(private val repository: DrinkRepository) {


    operator fun invoke(id: String): Flow<Result<DrinkDetails>> = flow {
        try {
            emit(Result.Loading<DrinkDetails>())
            val response = repository.getDrinkDetails(id)

            emit(Result.Success<DrinkDetails>(response.drinks.toDrinkDetails()[0]))
        } catch (e: HttpException) {
            emit(
                Result.Error<DrinkDetails>(
                    message = e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(
                Result.Error<DrinkDetails>(
                    message = e.localizedMessage ?: "Check your internet Connection"
                )
            )
        }

    }

}