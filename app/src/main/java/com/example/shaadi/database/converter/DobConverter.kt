package com.example.shaadi.database.converter

import androidx.room.TypeConverter
import com.example.shaadi.model.Dob
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DobConverter {

    @TypeConverter
    fun fromDob(list: Dob): String? {
        if (list == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Dob>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun toDob(string: String?): Dob? {
        if (string == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Dob>() {

        }.type
        return gson.fromJson(string, type)
    }

}


