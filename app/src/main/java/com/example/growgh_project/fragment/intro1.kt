package com.example.growgh_project.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.growgh_project.R
import com.example.growgh_project.databinding.FragmentIntro1Binding


class intro1 : Fragment() {

    lateinit var binding: FragmentIntro1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIntro1Binding.inflate(layoutInflater, container, false)

        binding.btnNext1.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_intro1_to_intro2)
        }

        binding.btnSkip1.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_intro1_to_home)
        }
        return binding.root
    }
}