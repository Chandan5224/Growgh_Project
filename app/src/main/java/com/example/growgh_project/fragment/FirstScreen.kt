package com.example.growgh_project.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.growgh_project.R
import com.example.growgh_project.databinding.FragmentIntro1Binding


class FirstScreen : Fragment() {

    private lateinit var binding: FragmentIntro1Binding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIntro1Binding.inflate(layoutInflater, container, false)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        sharedPreferences = requireActivity().getSharedPreferences(
            getString(R.string.preference_file_name),
            Context.MODE_PRIVATE
        )

        binding.btnNext1.setOnClickListener {
            viewPager?.currentItem = 1
        }

        binding.btnSkip1.setOnClickListener {
            sharedPreferences.edit().putBoolean("logIn", true).apply()
            findNavController().navigate(R.id.action_viewPagerFragment_to_home)
        }

        return binding.root
    }
}