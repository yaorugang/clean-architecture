package com.yaorugang.afterpay.ui.carlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaorugang.afterpay.domain.exception.DomainException
import com.yaorugang.afterpay.domain.exception.EmptyDataException
import com.yaorugang.afterpay.domain.manager.CarsManager
import com.yaorugang.afterpay.domain.model.Car
import com.yaorugang.afterpay.ui.utils.Event
import kotlinx.coroutines.launch
import javax.inject.Inject

class CarListViewModel @Inject constructor(
    private val carsManager: CarsManager
) : ViewModel() {

    private val _carItems = MutableLiveData<List<Car>>(emptyList())
    val carItems: LiveData<List<Car>> = _carItems

    private val _showLoadingSpinner = MutableLiveData(Event(false))
    val showLoadingSpinner: LiveData<Event<Boolean>> = _showLoadingSpinner

    fun fetchCars() {
        viewModelScope.launch {
            _showLoadingSpinner.postValue(Event(true))
            try {
                _carItems.value = carsManager.getCars()
            } catch (e: EmptyDataException) {

            } catch (e: DomainException) {

            } finally {
                _showLoadingSpinner.postValue(Event(false))
            }
        }
    }
}