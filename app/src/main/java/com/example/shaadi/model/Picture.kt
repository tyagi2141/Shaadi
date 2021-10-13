package com.example.shaadi.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Picture (

    @ColumnInfo(name = "large")
    @SerializedName("large") val large : String?,

    @ColumnInfo(name = "medium")
    @SerializedName("medium") val medium : String?,

    @ColumnInfo(name = "thumbnail")
    @SerializedName("thumbnail") val thumbnail : String?
):Parcelable