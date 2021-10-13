package com.example.shaadi.database.converter

import androidx.room.TypeConverter
import com.example.shaadi.model.Login
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LoginConverter {

    @TypeConverter
    fun fromLogin(list: Login): String? {
        if (list == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Login>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun toLogin(string: String?): Login? {
        if (string == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Login>() {

        }.type
        return gson.fromJson(string, type)
    }

}


