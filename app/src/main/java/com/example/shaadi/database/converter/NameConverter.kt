package com.example.shaadi.database.converter

import androidx.room.TypeConverter
import com.example.shaadi.model.Name
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class NameConverter {

    @TypeConverter
    fun fromName(list: Name): String? {
        if (list == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Name>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun toName(string: String?): Name? {
        if (string == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Name>() {

        }.type
        return gson.fromJson(string, type)
    }

}


