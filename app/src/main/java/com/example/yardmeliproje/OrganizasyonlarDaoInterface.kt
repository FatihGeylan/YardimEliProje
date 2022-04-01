package com.example.yardmeliproje

import retrofit2.Call
import retrofit2.http.GET

interface OrganizasyonlarDaoInterface {

    @GET("api/Organizations/GetOrganizations")
    fun tumOrganizasyonlar():Call<OrganizasyonlarCevap>

}