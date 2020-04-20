package com.example.androidstarter.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.androidstarter.list.domain.model.Entry
import com.example.androidstarter.list.domain.usecase.GetListItemsUseCase
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

enum class Colors{
   white, yellow, orange, red, purple, magenta, green, teal, blue, black
}

class ListViewModel @Inject constructor(
    private var getListItemsUseCase: GetListItemsUseCase
) : ViewModel() {
    private var plantListLiveData: LiveData<ViewState> = MutableLiveData()
    val plantListState: LiveData<ViewState>
        get() = plantListLiveData

    fun getPlantList() {
        plantListLiveData = liveData(Dispatchers.IO) {
            emit(ViewState.Loading)

            Colors.values().forEach {
                val list =getListItemsUseCase.invoke(it.name)
                emit(ViewState.Success(list))
            }
        }
    }

    sealed class ViewState {
        object Loading : ViewState()
        object Error : ViewState()
        data class Success(var list: List<Entry>) : ViewState()
    }
}
