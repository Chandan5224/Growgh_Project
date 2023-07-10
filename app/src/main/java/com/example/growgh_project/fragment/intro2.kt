package com.example.growgh_project.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.growgh_project.R
import com.example.growgh_project.databinding.FragmentIntro2Binding


class intro2 : Fragment() {

    lateinit var binding: FragmentIntro2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentIntro2Binding.inflate(layoutInflater, container, false)
        binding.btnNext2.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_intro2_to_intro3)
        }
        binding.btnSkip2.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_intro2_to_home)
        }
        return binding.root
    }


}