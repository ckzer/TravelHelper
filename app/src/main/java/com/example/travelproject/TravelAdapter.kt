package com.example.travelproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.travelproject.databinding.ListTravelBinding

class TravelAdapter(val travels: Array<Travel>) : RecyclerView.Adapter<TravelAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ListTravelBinding.inflate(LayoutInflater.from(parent.context))
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(travels[position])
    }

    override fun getItemCount()=travels.size

    class Holder(private val binding:ListTravelBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(travel: Travel) {
            binding.imageView.setImageResource(when(travel.name) {
                "경복궁" -> R.drawable.gyeongbok
                "광안리" -> R.drawable.gwang
                "을왕리" -> R.drawable.sea
                "광화문" -> R.drawable.gwangwhamun
                "해운대" -> R.drawable.gwang
                else -> {R.drawable.gyeongbok}
            })
            binding.txtName.text = travel.name
            binding.txtLocation.text=travel.location.toString()

            binding.root.setOnClickListener {
                Toast.makeText(binding.root.context,"여행지 :${travel.name}, 지역 : ${travel.location}",
                Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

}