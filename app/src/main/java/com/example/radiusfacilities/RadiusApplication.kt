package com.example.radiusfacilities

import android.app.Application
import com.example.radiusfacilities.api.RadiusApi
import com.example.radiusfacilities.api.RetrofitHelper
import com.example.radiusfacilities.db.FacilitiesDataBase
import com.example.radiusfacilities.repository.FacilitiesDataRepository

class RadiusApplication: Application() {

    lateinit var facilitiesDataRepository: FacilitiesDataRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val radiusApi = RetrofitHelper.getInstance().create(RadiusApi::class.java)
        val dataBase = FacilitiesDataBase.getDatabase(applicationContext)
        facilitiesDataRepository = FacilitiesDataRepository(radiusApi, dataBase, applicationContext)
    }
}