package com.example.shaadi.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Login (

    @ColumnInfo(name = "uuid")
    @SerializedName("uuid") val uuid : String?,

    @ColumnInfo(name = "username")
    @SerializedName("username") val username : String?,

    @ColumnInfo(name = "password")
    @SerializedName("password") val password : String?,

    @ColumnInfo(name = "salt")
    @SerializedName("salt") val salt : String?,

    @ColumnInfo(name = "md5")
    @SerializedName("md5") val md5 : String?,

    @ColumnInfo(name = "sha1")
    @SerializedName("sha1") val sha1 : String?,

    @ColumnInfo(name = "sha256")
    @SerializedName("sha256") val sha256 : String?
):Parcelable