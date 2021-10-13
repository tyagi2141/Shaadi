package com.example.shaadi.database.converter

import androidx.room.TypeConverter
import com.example.shaadi.model.Location
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LocationConverter {

    @TypeConverter
    fun fromLocation(list: Location): String? {
        if (list == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Location>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun toLocation(string: String?): Location? {
        if (string == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Location>() {

        }.type
        return gson.fromJson(string, type)
    }

}


