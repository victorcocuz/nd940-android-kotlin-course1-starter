package com.udacity.shoestore

import android.content.Context
import android.view.LayoutInflater.*
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe


class ShoeItem(context: Context) : LinearLayout(context) {
    private val binding: ShoeItemBinding = DataBindingUtil.inflate(from(context), R.layout.shoe_item, this,false)

    fun loadShoe(shoe: Shoe) {
        binding.apply {
            addView(this.root)
            shoeLayoutName.text = shoe.name
            shoeLayoutSize.text = shoe.size.toString()
            shoeLayoutCompany.text = shoe.company
            shoeLayoutDescription.text = shoe.description
        }
    }
}