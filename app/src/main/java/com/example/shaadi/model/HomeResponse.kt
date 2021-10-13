package com.example.shaadi.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class HomeResponse (

    @ColumnInfo(name = "results")
    @SerializedName("results") val results : List<Results>,

    @ColumnInfo(name = "info")
    @SerializedName("info") val info : Info
):Parcelable {
    override fun toString(): String {
        return "DashBoardResponse(results=$results, info=$info)"
    }
}