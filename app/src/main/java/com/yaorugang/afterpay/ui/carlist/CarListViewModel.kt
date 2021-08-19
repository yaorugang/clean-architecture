package com.yaorugang.afterpay.ui.carlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaorugang.afterpay.R
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

    private val _showError = MutableLiveData(false)
    val showError: LiveData<Boolean> = _showError

    private val _errorData = MutableLiveData<ErrorData>()
    val errorData: LiveData<ErrorData> = _errorData

    fun onRefresh() = viewModelScope.launch {
        fetchCars()
    }

    suspend fun fetchCars() {
        _showLoadingSpinner.value = Event(true)
        try {
            _carItems.value = carsManager.getCars()
            setError(false)
        } catch (e: EmptyDataException) {
            setError(
                true, ErrorData(
                    errorImageRes = R.drawable.ic_empty_data,
                    errorMessageRes = R.string.empty_car_list_error
                )
            )
        } catch (e: DomainException) {
            setError(
                true, ErrorData(
                    errorImageRes = R.drawable.ic_something_wrong,
                    errorMessageRes = R.string.car_list_fetching_error
                )
            )
        } finally {
            _showLoadingSpinner.value = Event(false)
        }
    }

    private fun setError(showError: Boolean, errorData: ErrorData? = null) {
        _errorData.value = errorData
        _showError.value = showError
    }
}