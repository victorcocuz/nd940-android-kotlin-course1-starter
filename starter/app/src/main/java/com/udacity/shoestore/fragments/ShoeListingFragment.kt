package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.SharedViewModel
import com.udacity.shoestore.ShoeItem
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.models.Shoe

class ShoeListingFragment : Fragment() {
    private val viewModel: SharedViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)
        setHasOptionsMenu(true)

        viewModel.shoeListLiveData.observe(viewLifecycleOwner, Observer {
            it?.forEach { shoe ->
                addView(shoe)
            }
        })

        binding.shoeListingFab.setOnClickListener {
            it.findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun addView(shoe: Shoe) {
        val shoeItem = ShoeItem(context!!)
        shoeItem.loadShoe(shoe)
        binding.shoeListingList.addView(shoeItem)
    }
}