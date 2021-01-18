package com.jgbravo.tvbillboard.ui.billboard.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.jgbravo.tvbillboard.data.UIState
import com.jgbravo.tvbillboard.databinding.ActivityBillboardBinding
import com.jgbravo.tvbillboard.ui.billboard.adapter.ChannelAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class BillboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBillboardBinding
    private lateinit var channelAdapter: ChannelAdapter

    private val viewModel: BillboardViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBillboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
        collectChannels()
    }

    private fun setUpRecyclerView() {
        channelAdapter = ChannelAdapter()
        binding.billboardRecyclerview.apply {
            adapter = channelAdapter
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    private fun collectChannels() {
        lifecycleScope.launchWhenStarted {
            viewModel.billboardList.collect {
                when (it) {
                    is UIState.Loading -> {
                        showLoader()
                    }
                    is UIState.Success -> {
                        hideLoader()
                        //channelAdapter.submitList(list)
                    }
                    is UIState.Error -> {
                        hideLoader()
                        Snackbar.make(
                            binding.root,
                            it.message,
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                    else -> Unit
                }
            }
        }
    }

    private fun hideLoader() {
        binding.billboardRecyclerview.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE
    }

    private fun showLoader() {
        binding.progressBar.visibility = View.VISIBLE
        binding.billboardRecyclerview.visibility = View.GONE
    }
}