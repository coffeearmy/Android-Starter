package com.example.androidstarter.features.list.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.androidstarter.features.list.domain.model.Entry
import com.example.androidstarter.features.list.domain.usecase.GetListItemsUseCase
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private var getListItemsUseCase: GetListItemsUseCase
) : ViewModel() {
    private var plantListLiveData: LiveData<ViewState> = MutableLiveData()
    val plantListState: LiveData<ViewState>
        get() = plantListLiveData

    fun getPlantList() {
        plantListLiveData = liveData(Dispatchers.IO) {
            emit(ViewState.Loading)
            val list = getListItemsUseCase.invoke("black")
            emit(ViewState.Success(list))
        }
    }

    sealed class ViewState {
        object Loading : ViewState()
        object Error : ViewState()
        data class Success(var list: List<Entry>) : ViewState()
    }
}
