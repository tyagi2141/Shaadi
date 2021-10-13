package com.example.shaadi.database.converter

import androidx.room.TypeConverter
import com.example.shaadi.model.Coordinates
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

 class CoordinatesConverter {

    @TypeConverter
    fun fromCoordinates(coordinates: Coordinates): String? {
        if (coordinates == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Coordinates>() {

        }.type
        return gson.toJson(coordinates, type)
    }

    @TypeConverter
    fun toCoordinates(string: String?): Coordinates? {
        if (string == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Coordinates>() {

        }.type
        return gson.fromJson(string, type)
    }

}


