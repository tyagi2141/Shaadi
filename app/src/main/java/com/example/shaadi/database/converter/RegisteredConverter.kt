package com.example.shaadi.database.converter

import androidx.room.TypeConverter
import com.example.shaadi.model.Registered
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RegisteredConverter {

    @TypeConverter
    fun fromRegistered(list: Registered): String? {
        if (list == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Registered>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun toRegistered(string: String?): Registered? {
        if (string == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Registered>() {

        }.type
        return gson.fromJson(string, type)
    }

}


