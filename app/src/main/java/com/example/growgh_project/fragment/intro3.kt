package com.example.growgh_project.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.growgh_project.R
import com.example.growgh_project.databinding.FragmentIntro1Binding
import com.example.growgh_project.databinding.FragmentIntro3Binding

class intro3 : Fragment() {

    lateinit var binding: FragmentIntro3Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIntro3Binding.inflate(layoutInflater, container, false)

        binding.btnNext3.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_intro3_to_home)
        }
        binding.btnSkip3.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_intro3_to_home)
        }
        return binding.root
    }


}