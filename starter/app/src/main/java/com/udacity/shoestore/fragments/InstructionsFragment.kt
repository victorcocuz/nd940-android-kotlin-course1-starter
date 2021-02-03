package com.udacity.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {
       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       val binding : FragmentInstructionsBinding =
           DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
       binding.instructionsButton.setOnClickListener(
           Navigation.createNavigateOnClickListener(R.id.action_instructionsFragment_to_shoeListingFragment)
       )
       return binding.root
    }
}