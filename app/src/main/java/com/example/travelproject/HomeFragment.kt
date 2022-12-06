package com.example.travelproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travelproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    val travels = arrayOf(
        Travel("경복궁", ELocation.Seoul),
        Travel("광화문", ELocation.Seoul),
        Travel("광안리", ELocation.Busan),
        Travel("을왕리", ELocation.Incheon),
        Travel("해운대", ELocation.Busan)
    )
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.recTravel.layoutManager=LinearLayoutManager(activity)
        binding.recTravel.adapter=TravelAdapter(travels)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}