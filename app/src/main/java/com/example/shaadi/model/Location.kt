package com.example.shaadi.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Location(
    @ColumnInfo(name = "street")
    @SerializedName("street") val street: Street?,

    @ColumnInfo(name = "city")
    @SerializedName("city") val city: String?,

    @ColumnInfo(name = "state")
    @SerializedName("state") val state: String?,

    @ColumnInfo(name = "country")
    @SerializedName("country") val country: String?,

    @ColumnInfo(name = "postcode")
    @SerializedName("postcode") val postcode: String?,

    @ColumnInfo(name = "coordinates")
    @SerializedName("coordinates") val coordinates: Coordinates?,

    @ColumnInfo(name = "timezone")
    @SerializedName("timezone") val timezone: Timezone?
) : Parcelable