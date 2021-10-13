package com.example.shaadi.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Street (

    @ColumnInfo(name = "number")
    @SerializedName("number") val number : Int?,

    @ColumnInfo(name = "name")
    @SerializedName("name") val name : String?
):Parcelable