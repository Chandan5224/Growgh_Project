package com.example.growgh_project.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.growgh_project.R
import com.example.growgh_project.adapter.ScreenSlidePagerAdapter
import com.example.growgh_project.databinding.FragmentViewPagerBinding


class ViewPagerFragment : Fragment() {

    lateinit var binding: FragmentViewPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentViewPagerBinding.inflate(layoutInflater, container, false)

        val fragmentList = arrayListOf<Fragment>(
            intro1(), intro2(), intro3()
        )
        val adapter = ScreenSlidePagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = adapter


        return binding.root
    }

}