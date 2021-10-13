package com.example.shaadi.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity
data class Results (
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "primerId")
    @SerializedName("primerId") val primerId : Int=0,

    @ColumnInfo(name = "gender")
    @SerializedName("gender") val gender : String?,

    @ColumnInfo(name = "name")
    @SerializedName("name") val name : Name?,

    @ColumnInfo(name = "location")
    @SerializedName("location") val location : Location?,

    @ColumnInfo(name = "email")
    @SerializedName("email") val email : String?,

    @ColumnInfo(name = "login")
    @SerializedName("login") val login : Login?,

    @ColumnInfo(name = "dob")
    @SerializedName("dob") val dob : Dob?,

    @ColumnInfo(name = "registered")
    @SerializedName("registered") val registered : Registered?,

    @ColumnInfo(name = "phone")
    @SerializedName("phone") val phone : String?,

    @ColumnInfo(name = "cell")
    @SerializedName("cell") val cell : String?,

    @ColumnInfo(name = "id")
    @SerializedName("id") val id : Id?,

    @ColumnInfo(name = "picture")
    @SerializedName("picture") val picture : Picture?,

    @ColumnInfo(name = "nat")
    @SerializedName("nat") val nat : String?,

    @ColumnInfo(name = "statusFlag")
    @SerializedName("statusFlag") var statusFlag : Int?,
):Parcelable