package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class SharedViewModel: ViewModel() {
    private val shoeList = mutableListOf<Shoe>()
    private val _shoeListLiveData = MutableLiveData<List<Shoe>>()

    val shoeListLiveData: LiveData<List<Shoe>>
        get() = _shoeListLiveData

    init {
        Timber.i("View model created")
    }

    fun addShoe(shoe: Shoe) {
        shoeList.add(shoe)
        _shoeListLiveData.value = shoeList
    }
}