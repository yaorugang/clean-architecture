package com.yaorugang.afterpay.ui.cardetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.yaorugang.afterpay.databinding.FragmentCarDetailsBinding
import com.yaorugang.afterpay.injection.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class CarDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: CarDetailsViewModel by viewModels { viewModelFactory }

    private lateinit var binding: FragmentCarDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCarDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}