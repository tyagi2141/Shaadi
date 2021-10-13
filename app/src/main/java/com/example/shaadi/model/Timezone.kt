package com.example.shaadi.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Timezone (

    @ColumnInfo(name = "offset")
    @SerializedName("offset") val offset : String?,

    @ColumnInfo(name = "description")
    @SerializedName("description") val description : String?
):Parcelable