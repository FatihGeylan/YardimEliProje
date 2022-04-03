package com.example.yardmeliproje

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_organization_home.*
import kotlinx.android.synthetic.main.fragment_organization_home.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class OrganizationHomeFragment : Fragment() {


    private  lateinit var  organizasyonlist:ArrayList<organizasyon_test>
    private lateinit var  adapter:organizasyonRVAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val tasarim= inflater.inflate(R.layout.fragment_organization_home, container, false)

        //organizasyon_recyclerView.setHasFixedSize(true)
        organizasyon_recyclerView.layoutManager = LinearLayoutManager(activity)
        tasarim.organizasyon_recyclerView.layoutManager=LinearLayoutManager(activity)
        tasarim.organizasyon_recyclerView.adapter=

        val o1= organizasyon_test("1","Anne çocuk dsadas","acev","acev.jpg")
        val o2= organizasyon_test("2","merte gotten","akut","akut.jpg")
        organizasyonlist= ArrayList<organizasyon_test>()
        organizasyonlist.add(o1)
        organizasyonlist.add(o2)
        adapter= organizasyonRVAdapter(requireContext(),organizasyonlist)
        organizasyon_recyclerView.adapter=adapter

        Log.e("as","3")
        tumOrganizasyonlar()


        return tasarim
    }

    fun tumOrganizasyonlar(){

        Log.e("as","5")
        val kdi = ApiUtils.getOrganizasyonlarDaoInterface()

        kdi.tumOrganizasyonlar().enqueue(object : Callback<OrganizasyonlarCevap>{

            override fun onResponse(call: Call<OrganizasyonlarCevap>?, response: Response<OrganizasyonlarCevap>?) {

                if(response != null){

                    val orgList = response.body().data

                    for(k in orgList){

                        Log.e("*******","*******")
                        Log.e("Kişi ad",k.id)
                        Log.e("Kişi tel",k.name)
                        Log.e("Kişi tel",k.shortName)
                        Log.e("Kişi tel",k.description)
                        Log.e("Kişi tel",k.accountNumber)
                        Log.e("Kişi tel",k.photoUrl)
                        Log.e("Kişi tel",k.balance)

                    }

                }

            }

            override fun onFailure(call: Call<OrganizasyonlarCevap>?, t: Throwable?) {
                if (t != null) {
                    Log.e("hata",t.message.toString())
                }
            }

        })

    }


}