package com.example.shaadi.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Name(

    @ColumnInfo(name = "title")
    @SerializedName("title") val title: String?,

    @ColumnInfo(name = "first")
    @SerializedName("first") val first: String?,

    @ColumnInfo(name = "last")
    @SerializedName("last") val last: String?
) : Parcelable