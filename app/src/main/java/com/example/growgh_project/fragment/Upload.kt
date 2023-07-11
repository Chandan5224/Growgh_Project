package com.example.growgh_project.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.growgh_project.R
import com.example.growgh_project.databinding.FragmentUploadBinding


class Upload : Fragment() {

    private lateinit var binding: FragmentUploadBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUploadBinding.inflate(layoutInflater, container, false)

        val selectImageIntent = registerForActivityResult(ActivityResultContracts.GetContent())
        { uri ->

            if (uri != null) {
                binding.imageView.setImageURI(uri)
                binding.btnClose.visibility = View.VISIBLE
            } else {
                binding.btnClose.visibility = View.GONE
                binding.imageView.setImageDrawable(resources.getDrawable(R.drawable.upload_img))
            }

        }

        binding.btnBack.setOnClickListener {
            activity!!.onBackPressedDispatcher.onBackPressed()
        }
        binding.btnSelectImg.setOnClickListener {
            selectImageIntent.launch("image/*")
        }
        binding.btnClose.setOnClickListener {
            binding.btnClose.visibility = View.GONE
            binding.imageView.setImageDrawable(resources.getDrawable(R.drawable.upload_img))
        }

        return binding.root
    }
}