package com.example.radiusfacilities.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.radiusfacilities.model.FacilitiesData

@Dao
interface  FacilitiesDao {

    @Insert
    suspend fun addFacilitiesData(data: FacilitiesData)

    @Query("SELECT * FROM facilities_data")
    suspend fun getFacilitiesData(): FacilitiesData

    @Query("DELETE FROM facilities_data")
    suspend fun removeFacilitiesData()
}