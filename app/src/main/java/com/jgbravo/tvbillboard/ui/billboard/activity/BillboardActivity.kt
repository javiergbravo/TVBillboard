package com.jgbravo.tvbillboard.ui.billboard.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.core.view.get
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar
import com.jgbravo.tvbillboard.R
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
        //setUpFilters()
        collectChannels()
    }

    /* Prepare components */
    private fun setUpRecyclerView() {
        channelAdapter = ChannelAdapter()
        binding.billboardRecyclerview.apply {
            adapter = channelAdapter
            layoutManager = GridLayoutManager(context, 3)
        }
    }

    private fun setUpFilters() {

        binding.filters.setOnClickListener {
            val selectedChips = binding.filters.children
                .filter { (it as Chip).isChecked }
                .map { (it as Chip).text.toString() }
        }
        /*
        binding.filters.apply {
            setOnCheckedChangeListener { group, checkedId ->
                val filtersSelected = chipList.filter { it.isSelected }
                viewModel.filterChannel(filtersSelected)
            }
        }
        */

        binding.cleanFilterButton.setOnClickListener {
            binding.filters.clearCheck() // Clean all filters
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
                    binding.filters.setNewList(viewModel.allCategories)
                    setUpFilters()
                }
                Resource.State.ERROR -> {
                    hideLoader()
                    Snackbar.make(binding.root, it.message!!, Snackbar.LENGTH_LONG).show()
                }
            }
        })
    }

    /* Visibility changes */
    private fun hideLoader() {
        binding.billboardRecyclerview.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE
    }

    private fun showLoader() {
        binding.progressBar.visibility = View.VISIBLE
        binding.billboardRecyclerview.visibility = View.GONE
    }

    private fun toggleFilterVisibility() {
        binding.filterLayout.apply {
            isVisible = !isVisible
        }
    }

    /* Menu */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.filter_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_favorite -> {
            toggleFilterVisibility()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}