package com.example.growgh_project.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.growgh_project.R
import com.example.growgh_project.databinding.FragmentHomeBinding


class Home : Fragment() {

    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(layoutInflater, container, false)

        binding.btnFeeds.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_home_to_feeds)
        }
        return binding.root
    }
}