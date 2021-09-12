package com.gaur.cocktails.presentation.drink_details

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaur.cocktails.common.Constants
import com.gaur.cocktails.common.Result
import com.gaur.cocktails.common.TAG
import com.gaur.cocktails.domain.use_case.get_cocktail_detail.GetDrinkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DrinkDetailsViewModel @Inject constructor(
    private val getDrinkDetailsUseCase: GetDrinkUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {


    private val _drinkDetailsState = mutableStateOf(GetDrinkDetailState())
    val drinkDetailsState: State<GetDrinkDetailState> = _drinkDetailsState

    init {
        savedStateHandle.get<String>(Constants.DRINK_ID_PARAMS)?.let {
            getDrinkDetails(it)
        }
    }


    private fun getDrinkDetails(id: String) {
        getDrinkDetailsUseCase(id).onEach {
            Log.d(TAG, "getDrinkDetails: ${it.data}")
            when (it) {
                is Result.Loading -> {
                    _drinkDetailsState.value = GetDrinkDetailState(isLoading = true)
                }
                is Result.Success -> {
                    _drinkDetailsState.value = GetDrinkDetailState(drink = it.data)
                }
                is Result.Error -> {
                    _drinkDetailsState.value = GetDrinkDetailState(error = it.message)
                }
            }
        }.launchIn(viewModelScope)
    }


}