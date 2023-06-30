package com.example.radiusfacilities.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "facilities_data")
data class FacilitiesData(
    @PrimaryKey(autoGenerate = true)
    val facilitiesDataId: Int,
    @TypeConverters(MyTypeConverters::class)
    val exclusions: List<List<Exclusion>>,
    @TypeConverters(MyTypeConverters::class)
    val facilities: List<Facility>
)