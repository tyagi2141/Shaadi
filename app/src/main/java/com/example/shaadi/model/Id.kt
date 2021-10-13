package com.example.shaadi.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Id (

    @ColumnInfo(name = "name")
    @SerializedName("name") val name : String?,

    @ColumnInfo(name = "value")
    @SerializedName("value") val value : String?
):Parcelable