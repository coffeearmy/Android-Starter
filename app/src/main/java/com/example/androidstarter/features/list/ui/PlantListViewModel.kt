package com.example.androidstarter.features.list.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.androidstarter.features.list.domain.model.Plant
import com.example.androidstarter.features.list.domain.usecase.GetPlantsUseCase
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class PlantListViewModel @Inject constructor(
    var getPlantsUseCase: GetPlantsUseCase
) : ViewModel() {

    private var plantListLiveData: LiveData<ViewState> = MutableLiveData()
    val plantListState: LiveData<ViewState>
        get() = plantListLiveData

    fun getPlantList() {
        plantListLiveData = liveData(Dispatchers.IO) {
            emit(ViewState.Loading)
            val list = getPlantsUseCase.invoke("pine")
            emit(ViewState.Success(list))
        }
    }

    sealed class ViewState {
        object Loading : ViewState()
        object Error : ViewState()
        data class Success(var list: List<Plant>) : ViewState()
    }
}
