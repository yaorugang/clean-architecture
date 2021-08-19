package com.yaorugang.afterpay.ui.carlist

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.yaorugang.afterpay.R
import com.yaorugang.afterpay.databinding.FragmentCarListBinding
import com.yaorugang.afterpay.injection.ViewModelFactory
import com.yaorugang.afterpay.ui.MainActivity
import com.yaorugang.afterpay.ui.utils.EventObserver
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class CarListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: CarListViewModel by viewModels { viewModelFactory }

    private lateinit var binding: FragmentCarListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCarListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // show settings menu on the toolbar
        (activity as MainActivity).showSettingsMenu(true)

        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                ContextCompat.getDrawable(context, R.drawable.space_divider)?.let { setDrawable(it) }
            })
            adapter = CarListAdapter()
        }

        binding.swipeRefreshLayout.apply {
            setOnRefreshListener {
                viewModel.onRefresh()
            }
            setColorSchemeColors(Color.GREEN) // Set loading spinner color
        }

        viewModel.showLoadingSpinner.observe(viewLifecycleOwner, EventObserver {
            binding.swipeRefreshLayout.isRefreshing = it
        })

        // initial fetching cars
        viewModel.onRefresh()
    }
}