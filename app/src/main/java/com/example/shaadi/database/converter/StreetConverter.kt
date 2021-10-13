package com.example.shaadi.database.converter

import androidx.room.TypeConverter
import com.example.shaadi.model.Street
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StreetConverter {

    @TypeConverter
    fun fromStreet(list: Street): String? {
        if (list == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Street>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun toStreet(string: String?): Street? {
        if (string == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Street>() {

        }.type
        return gson.fromJson(string, type)
    }

}


