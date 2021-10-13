package com.example.shaadi.database.converter

import androidx.room.TypeConverter
import com.example.shaadi.model.Picture
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PictureConverter {

    @TypeConverter
    fun fromPicture(list: Picture): String? {
        if (list == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Picture>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun toPicture(string: String?): Picture? {
        if (string == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Picture>() {

        }.type
        return gson.fromJson(string, type)
    }

}


