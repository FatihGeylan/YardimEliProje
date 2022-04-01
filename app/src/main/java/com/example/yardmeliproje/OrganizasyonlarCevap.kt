package com.example.yardmeliproje

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class OrganizasyonlarCevap(
    @SerializedName("data")
    @Expose
    var data:List<Organizasyonlar>,
    @SerializedName("resultStatus")
    @Expose
    var resultStatus:Int)
{
}