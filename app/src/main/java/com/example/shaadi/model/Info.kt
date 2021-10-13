package com.example.shaadi.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Info(

    @ColumnInfo(name = "seed")
    @SerializedName("seed") val seed: String?,

    @ColumnInfo(name = "results")
    @SerializedName("results") val results: Int?,

    @ColumnInfo(name = "page")
    @SerializedName("page") val page: Int?,

    @ColumnInfo(name = "version")
    @SerializedName("version") val version: Double?
) : Parcelable