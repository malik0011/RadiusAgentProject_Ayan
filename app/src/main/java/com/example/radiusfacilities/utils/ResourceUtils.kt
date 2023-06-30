package com.example.radiusfacilities.utils

import com.example.radiusfacilities.R

class ResourceUtils {
    companion object {
        fun getResourceId(type: String): Int {
            return when (type) {
                "apartment" ->  R.drawable.ic_apartment
                "condo" -> R.drawable.ic_condo
                "boat" -> R.drawable.ic_boat
                "land" -> R.drawable.ic_land
                "rooms" -> R.drawable.ic_rooms
                "no-room" -> R.drawable.ic_no_room
                "swimming" -> R.drawable.ic_swimming
                "garden" -> R.drawable.ic_garden
                "garage" -> R.drawable.ic_garage
                else -> R.drawable.ic_apartment
            }
        }
    }
}