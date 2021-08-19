package com.yaorugang.afterpay.ui.information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.yaorugang.afterpay.databinding.FragmentInformationBinding
import com.yaorugang.afterpay.injection.ViewModelFactory
import com.yaorugang.afterpay.ui.MainActivity
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class InformationFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: InformationViewModel by viewModels { viewModelFactory }

    private lateinit var binding: FragmentInformationBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // hide settings menu on the toolbar
        (activity as MainActivity).showSettingsMenu(false)
    }
}