package com.example.travelproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.travelproject.databinding.FragmentTravelDetailBinding


class TravelDetailFragment : Fragment() {
    private lateinit var binding: FragmentTravelDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentTravelDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
}