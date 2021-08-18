package com.yaorugang.afterpay.ui.carlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaorugang.afterpay.domain.exception.DomainException
import com.yaorugang.afterpay.domain.exception.EmptyDataException
import com.yaorugang.afterpay.domain.manager.CarsManager
import com.yaorugang.afterpay.domain.model.Car
import kotlinx.coroutines.launch
import javax.inject.Inject

class CarListViewModel @Inject constructor(
    private val carsManager: CarsManager
) : ViewModel() {

    private val _carItems = MutableLiveData<List<Car>>(emptyList())
    val carItems: LiveData<List<Car>> = _carItems

    fun onStart() {
        getCars()
    }

    private fun getCars() {
        viewModelScope.launch {
            try {
                _carItems.value = carsManager.getCars()
            } catch (e: EmptyDataException) {

            } catch (e: DomainException) {

            }
        }
    }
}