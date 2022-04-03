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


    private  lateinit var  organizasyonlist:ArrayList<Organizasyonlar>
    private lateinit var  adapter:organizasyonRVAdapter
    private lateinit var  kdi:OrganizasyonlarDaoInterface
    //private lateinit var response: Response<OrganizasyonlarCevap>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val tasarim= inflater.inflate(R.layout.fragment_organization_home, container, false)

        return tasarim
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        organizasyon_recyclerView.setHasFixedSize(true)
        organizasyon_recyclerView.layoutManager = LinearLayoutManager(activity)
        organizasyonlist= ArrayList<Organizasyonlar>()
        //organizasyonlist= ArrayList<Organizasyonlar>()
        /*val o1= Organizasyonlar("1","Anne çocuk dsadas","acev","acev")
        val o2= Organizasyonlar("2","merte gotten","akut","akut")
        organizasyonlist= ArrayList<Organizasyonlar>()
        organizasyonlist.add(o1)
        organizasyonlist.add(o2)*/
        kdi = ApiUtils.getOrganizasyonlarDaoInterface()
        tumOrganizasyonlar()


        Log.e("as","3")

    }

    fun tumOrganizasyonlar(){

        Log.e("as","5")


        kdi.tumOrganizasyonlar().enqueue(object : Callback<OrganizasyonlarCevap>{

            override fun onResponse(call: Call<OrganizasyonlarCevap>?, response: Response<OrganizasyonlarCevap>?) {

                if(response != null){

                    val orgList = response.body().data
                    adapter= organizasyonRVAdapter(requireContext(),orgList)
                    organizasyon_recyclerView.adapter=adapter



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