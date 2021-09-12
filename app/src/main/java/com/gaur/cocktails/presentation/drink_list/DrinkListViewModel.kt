package com.gaur.cocktails.presentation.drink_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaur.cocktails.common.Constants
import com.gaur.cocktails.common.Result
import com.gaur.cocktails.domain.use_case.get_cocktail_list.GetDrinkListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DrinkListViewModel @Inject constructor(
    private val drinkListUseCase: GetDrinkListUseCase,
    val savedStateHandle: SavedStateHandle
) :
    ViewModel() {


    private val _drinkListState = mutableStateOf<GetDrinkListState>(GetDrinkListState())
    val drinkListState: State<GetDrinkListState> = _drinkListState

    init {
        savedStateHandle.getLiveData<String>(Constants.SEARCH_QUERY).observeForever {
            getDrinkList(it)
        }
    }


    fun getDrinkList(s: String) {

        drinkListUseCase(s).onEach {
            when (it) {
                is Result.Loading -> {
                    _drinkListState.value = GetDrinkListState(isLoading = true)
                }
                is Result.Success -> {
                    _drinkListState.value = GetDrinkListState(data = it.data ?: emptyList())
                }
                is Result.Error -> {
                    _drinkListState.value = GetDrinkListState(error = it.message)
                }
            }
        }.launchIn(viewModelScope)


    }

    override fun onCleared() {

        super.onCleared()
    }


}