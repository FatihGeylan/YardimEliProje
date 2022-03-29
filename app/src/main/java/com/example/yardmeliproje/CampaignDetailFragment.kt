package com.example.yardmeliproje

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_campaign_detail.view.*


class CampaignDetailFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val tasarim= inflater.inflate(R.layout.fragment_campaign_detail, container, false)

        tasarim.goToCampaignPayButton.setOnClickListener{

            Navigation.findNavController(it).navigate(R.id.goToCampaignPayAction)


        }

        return  tasarim
    }

}