package com.example.shaadi.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.shaadi.database.converter.*
import com.example.shaadi.database.dao.HomeDao
import com.example.shaadi.model.Results

@Database(
    entities = [
        Results::class

    ], version = 1
)


@TypeConverters(
    CoordinatesConverter::class,
    DobConverter::class,
    IdConverter::class,
    LocationConverter::class,
    LoginConverter::class,
    NameConverter::class,
    PictureConverter::class,
    RegisteredConverter::class,
    StreetConverter::class,
    TimezoneConverter::class
)

abstract class AppDatabase : RoomDatabase() {

    companion object {
        val DATABASE_NAME: String = "shaadi_db"
    }

    abstract fun homeDao(): HomeDao

}








