package com.example.radiusfacilities.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MyTypeConverters {
    @TypeConverter
    fun fromExclusionsList(exclusions: List<List<Exclusion>>): String {
        return Gson().toJson(exclusions)
    }

    @TypeConverter
    fun toExclusionsList(value: String): List<List<Exclusion>> {
        val type = object : TypeToken<List<List<Exclusion>>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun fromFacilitiesList(facilities: List<Facility>): String {
        return Gson().toJson(facilities)
    }

    @TypeConverter
    fun toFacilitiesList(value: String): List<Facility> {
        val type = object : TypeToken<List<Facility>>() {}.type
        return Gson().fromJson(value, type)
    }
}
