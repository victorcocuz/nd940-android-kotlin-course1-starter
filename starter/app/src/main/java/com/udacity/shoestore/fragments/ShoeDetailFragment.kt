package com.udacity.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.SharedViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: SharedViewModel by activityViewModels()
    private var shoe: Shoe = Shoe("", 0.0, "", "")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.shoe = shoe
        binding.shoeDetailButtonSave.setOnClickListener {
            viewModel.addShoe(shoe)
            it.findNavController().navigate(
                ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment()
            )
        }
        binding.shoeDetailButtonDiscard.setOnClickListener {
            it.findNavController()
                .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment())
        }
        return binding.root
    }
}