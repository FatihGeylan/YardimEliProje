package com.example.yardmeliproje

import android.content.Context
import android.graphics.ColorSpace
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider.getApplicationContext

class organizasyonRVAdapter(private val mContext:Context
,private  val organizasyonListesi:List<Organizasyonlar>):RecyclerView.Adapter<organizasyonRVAdapter.organizasyonNesneTutucu>() {
    inner class organizasyonNesneTutucu(view: View) : RecyclerView.ViewHolder(view){
        var organizasyonCV: CardView
        var organizasyon_kisa: TextView
        var organizasyon_uzun: TextView
        var organizasyon_gorsel: ImageView
        init {
            organizasyonCV = view.findViewById(R.id.organizasyon_cardView)
            organizasyon_kisa = view.findViewById(R.id.organizasyon_kisa)
            organizasyon_uzun = view.findViewById(R.id.organizasyon_uzun)
            organizasyon_gorsel = view.findViewById(R.id.organizasyon_gorsel)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): organizasyonNesneTutucu {
        val tasarim = LayoutInflater.from(parent.context).inflate(R.layout.organizasyon_linear, parent, false)
        return organizasyonNesneTutucu(tasarim)
    }
    override fun onBindViewHolder(holder: organizasyonNesneTutucu, position: Int) {
        val organizasyon = organizasyonListesi[position]
        holder.organizasyon_kisa.text = organizasyon.shortName
        holder.organizasyon_uzun.text = organizasyon.name
        holder.organizasyon_gorsel.setImageResource(
            mContext.resources.getIdentifier(
                organizasyon.photoUrl.dropLast(
                    4
                ), "drawable", mContext.packageName
            )
        )
        holder.itemView.setOnClickListener{
            val gecis = OrganizationHomeFragmentDirections.goToOrgDetailAction(organizasyonListesi[position].photoUrl,organizasyonListesi[position].name, organizasyonListesi[position].description)

            Navigation.findNavController(it).navigate(gecis)
        }
    }
    override fun getItemCount(): Int {
        return organizasyonListesi.size
    }
}
