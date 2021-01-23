package com.jgbravo.tvbillboard.ui.billboard.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.jgbravo.tvbillboard.data.entities.Resource
import com.jgbravo.tvbillboard.databinding.ActivityBillboardBinding
import com.jgbravo.tvbillboard.ui.billboard.adapter.ChannelAdapter
import dagger.hilt.android.AndroidEntryPoint

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
            layoutManager = GridLayoutManager(context, 3)
        }
    }

    private fun collectChannels() {
        viewModel.channelList.observe(this, {
            when (it.state) {
                Resource.State.LOADING -> {
                    showLoader()
                }
                Resource.State.SUCCESS -> {
                    hideLoader()
                    channelAdapter.submitList(it.data!!)
                }
                Resource.State.ERROR -> {
                    hideLoader()
                    Snackbar.make(binding.root, it.message!!, Snackbar.LENGTH_LONG).show()
                }
            }
        })
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