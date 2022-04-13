package com.example.yardmeliproje

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_organization_detail.*


class OrganizationDetailFragment : Fragment() {
    var id: Int? = null
    var Isim: String = ""
    var aciklama: String = ""
    var resim: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val tasarim = inflater.inflate(R.layout.fragment_organization_detail,container,false)
        return tasarim
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle:OrganizationDetailFragmentArgs by navArgs()
        Isim= bundle.organizasyonAyrintiIsim
        organizasyonAyrntıIsim.text=Isim
        resim=bundle.organizasyonAyrintiResim
        organizasyonAyrntıResim.setImageResource(
            this.resources.getIdentifier(
                resim.dropLast(4
                ),"drawable",context!!.packageName
            )
        )

    }

}