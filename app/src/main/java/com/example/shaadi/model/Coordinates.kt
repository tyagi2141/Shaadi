package com.example.shaadi.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coordinates (
	@ColumnInfo(name = "latitude")
	@SerializedName("latitude") val latitude : Double?,

	@ColumnInfo(name = "longitude")
	@SerializedName("longitude") val longitude : Double?
):Parcelable