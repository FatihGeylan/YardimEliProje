package com.example.yardmeliproje

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Organizasyonlar(
    @SerializedName("id")
    @Expose
    var id:String,
    @SerializedName("name")
    @Expose
    var name:String,
    @SerializedName("shortName")
    @Expose
    var shortName:String,
    @SerializedName("description")
    @Expose
    var description:String,
    @SerializedName("balance")
    @Expose
    var balance:String,
    @SerializedName("photoUrl")
    @Expose
    var photoUrl:String,
    @SerializedName("accountNumber")
    @Expose
    var accountNumber:String,
)
{
}