package com.gaur.cocktails.domain.use_case.get_cocktail_list

import android.util.Log
import com.gaur.cocktails.common.Result
import com.gaur.cocktails.common.TAG
import com.gaur.cocktails.data.remote.dto.toDrinkList
import com.gaur.cocktails.domain.model.Drink
import com.gaur.cocktails.domain.repository.DrinkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetDrinkListUseCase @Inject constructor(private val repository: DrinkRepository) {


    operator fun invoke(s: String): Flow<Result<List<Drink>>> = flow {
        try {
            emit(Result.Loading<List<Drink>>())
            val response = repository.getDrinkList(s)
            Log.d(TAG, "invoke: ${response}")
            emit(Result.Success<List<Drink>>(data = response.drinks.toDrinkList()))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(
                Result.Error<List<Drink>>(
                    message = e.localizedMessage ?: "An unexpected error occured"
                )
            )
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Result.Error<List<Drink>>(message = "Check your Internet Connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.Error<List<Drink>>(message = "Check your Internet Connection"))
        }
    }
}