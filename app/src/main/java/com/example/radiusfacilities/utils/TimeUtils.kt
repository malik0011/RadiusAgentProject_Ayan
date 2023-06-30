package com.example.radiusfacilities.utils

import android.content.Context
import java.util.*

class TimeUtils {

    companion object {

        private val PREF_FILE_NAME = "MyPrefs"
        private val KEY_LAST_STORE_DATE = "lastShownDate"

        fun shouldShowToday(context: Context): Boolean {
            val sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
            val lastStoreTime = sharedPreferences.getString(KEY_LAST_STORE_DATE, null)

            val currentDate = Calendar.getInstance().get(Calendar.DATE).toString()

            if (lastStoreTime == currentDate) {
                // The item was already stored today
                return false
            }

            // Store the current date as the last stored date
            sharedPreferences.edit().putString(KEY_LAST_STORE_DATE, currentDate).apply()

            return true
        }
    }

}