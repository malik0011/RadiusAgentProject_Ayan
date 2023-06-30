package com.example.radiusfacilities.repository

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.radiusfacilities.api.RadiusApi
import com.example.radiusfacilities.db.FacilitiesDataBase
import com.example.radiusfacilities.model.FacilitiesData
import com.example.radiusfacilities.utils.NetWorkUtils
import com.example.radiusfacilities.utils.TimeUtils

class FacilitiesDataRepository(
    private val apiService: RadiusApi,
    private val facilitiesDataBase: FacilitiesDataBase,
    private val applicationContext: Context
) {
    private val facilitiesLiveData = MutableLiveData<FacilitiesData>()

    val  facilitiesData : LiveData<FacilitiesData>
    get() = facilitiesLiveData

    suspend fun getFacilitiesData() {
        //checking is this the first time of the day we are opening the app and we we also connecting to internet
        if (NetWorkUtils.isInternetAvailable(applicationContext) && TimeUtils.shouldShowToday(applicationContext)) {
            //if true the calling the
            val result = apiService.getFacilitiesAndExclusionsData()
            if (result?.body() != null) {
                //if result is not null
                //first we are removing the previous data from local db to avoid duplicates in db
                facilitiesDataBase.facilitiesDao().removeFacilitiesData()
                facilitiesDataBase.facilitiesDao().addFacilitiesData(result.body()!!) //adding the new data
                facilitiesLiveData.postValue(result.body()) //updating the livedata observer
            }
        } else {
            //else just store it form the local db
            val data  = facilitiesDataBase.facilitiesDao().getFacilitiesData()
            if(data != null) facilitiesLiveData.postValue(data) //checking if data is there if not then this the first time
            else Toast.makeText(applicationContext, "turn on internet first & relaunch the app!!", Toast.LENGTH_SHORT)
        }
    }
}