package com.example.yardmeliproje

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_campaign_home.view.*


class CampaignHomeFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val tasarim= inflater.inflate(R.layout.fragment_campaign_home, container, false)

        tasarim.goToCampaignsDetail.setOnClickListener{

            Navigation.findNavController(it).navigate(R.id.goToCampaignDetailAction)


        }


        return tasarim
    }


}