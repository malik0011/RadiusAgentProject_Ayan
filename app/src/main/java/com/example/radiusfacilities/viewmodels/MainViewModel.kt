package com.example.radiusfacilities.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.radiusfacilities.model.FacilitiesData
import com.example.radiusfacilities.repository.FacilitiesDataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: FacilitiesDataRepository) : ViewModel() {

    init {
        viewModelScope.launch (Dispatchers.IO){
            //on initialization calling the data
            repository.getFacilitiesData()
        }
    }

    val facilitiesData: LiveData<FacilitiesData>
    get() = repository.facilitiesData
}