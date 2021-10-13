package com.example.shaadi.database.converter

import androidx.room.TypeConverter
import com.example.shaadi.model.Id
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class IdConverter {

    @TypeConverter
    fun fromId(list: Id): String? {
        if (list == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Id>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun toId(string: String?): Id? {
        if (string == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Id>() {

        }.type
        return gson.fromJson(string, type)
    }

}


