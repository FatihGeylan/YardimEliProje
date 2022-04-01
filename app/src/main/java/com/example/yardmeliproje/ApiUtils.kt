package com.example.yardmeliproje

class ApiUtils {

    companion object{

        val BASE_URL="http://yardimeli.somee.com/"

        fun getOrganizasyonlarDaoInterface():OrganizasyonlarDaoInterface{

            return RetrofitClient.getClient(BASE_URL).create(OrganizasyonlarDaoInterface::class.java)
        }


    }

}