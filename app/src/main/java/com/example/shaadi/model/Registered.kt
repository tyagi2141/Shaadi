package com.example.shaadi.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Registered (

    @ColumnInfo(name = "date")
    @SerializedName("date") val date : String?,

    @ColumnInfo(name = "age")
    @SerializedName("age") val age : Int?
):Parcelable