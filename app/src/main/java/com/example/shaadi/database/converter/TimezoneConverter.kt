package com.example.shaadi.database.converter

import androidx.room.TypeConverter
import com.example.shaadi.model.Timezone
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TimezoneConverter {

    @TypeConverter
    fun fromTimezone(list: Timezone): String? {
        if (list == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Timezone>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun toTimezone(string: String?): Timezone? {
        if (string == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Timezone>() {

        }.type
        return gson.fromJson(string, type)
    }

}


