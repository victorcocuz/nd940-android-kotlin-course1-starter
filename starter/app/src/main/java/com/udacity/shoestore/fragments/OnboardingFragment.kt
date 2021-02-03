package com.udacity.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentOnboardingBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_onboarding, container, false)
        binding.onboardingButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_onboardingFragment_to_instructionsFragment)
        )
        return binding.root
    }
}