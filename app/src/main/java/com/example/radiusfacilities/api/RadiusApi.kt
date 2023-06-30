package com.example.radiusfacilities.api

import com.example.radiusfacilities.model.FacilitiesData
import retrofit2.Response
import retrofit2.http.GET

interface RadiusApi {
    @GET("db")
    suspend fun getFacilitiesAndExclusionsData(): Response<FacilitiesData>
}