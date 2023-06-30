package com.example.radiusfacilities.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.radiusfacilities.model.FacilitiesData
import com.example.radiusfacilities.model.MyTypeConverters

@Database(entities = [FacilitiesData::class], version = 1)
@TypeConverters(MyTypeConverters::class)
abstract class FacilitiesDataBase : RoomDatabase() {

    abstract fun facilitiesDao(): FacilitiesDao

    companion object{
        @Volatile
        private var INSTANCE: FacilitiesDataBase? = null

        fun getDatabase(context: Context): FacilitiesDataBase {
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        FacilitiesDataBase::class.java,
                        "facilitiesDB")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}