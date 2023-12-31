package com.example.growgh_project.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.growgh_project.R
import com.example.growgh_project.adapter.ScreenSlidePagerAdapter
import com.example.growgh_project.databinding.FragmentViewPagerBinding


class ViewPagerFragment : Fragment() {

    lateinit var binding: FragmentViewPagerBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentViewPagerBinding.inflate(layoutInflater, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(), SecondScreen(), ThirdScreen()
        )
        val adapter = ScreenSlidePagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        sharedPreferences = requireActivity().getSharedPreferences(
            getString(R.string.preference_file_name),
            Context.MODE_PRIVATE
        )
        val logIn = sharedPreferences.getBoolean("logIn", false)
        if (logIn)
            findNavController().navigate(R.id.action_viewPagerFragment_to_home)

        binding.viewPager.adapter = adapter

        return binding.root
    }

}