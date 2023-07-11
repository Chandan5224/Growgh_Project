package com.example.growgh_project.fragment

import android.content.Context
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.growgh_project.MainActivity
import com.example.growgh_project.R
import com.example.growgh_project.databinding.FragmentIntro1Binding
import java.io.File
import java.io.FileInputStream
import java.io.IOException


class intro1 : Fragment() {

    lateinit var binding: FragmentIntro1Binding
    lateinit var sharedPreferences: SharedPreferences
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
            sharedPreferences.edit().putBoolean("logIn", true).apply()
            binding.root.findNavController().navigate(R.id.action_intro1_to_home)
        }
        sharedPreferences = requireActivity().getSharedPreferences(
            getString(R.string.preference_file_name),
            Context.MODE_PRIVATE
        )
        val navHostFragment =
            activity!!.supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        val navController = navHostFragment.navController
        val logIn = sharedPreferences.getBoolean("logIn", false)
        if (logIn) {
            navController.navigate(R.id.action_intro1_to_home)
        }
        return binding.root
    }
}