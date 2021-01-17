package com.jgbravo.tvbillboard.ui.billboard.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.jgbravo.tvbillboard.data.UIState
import com.jgbravo.tvbillboard.databinding.ActivityBillboardBinding
import kotlinx.coroutines.flow.collect
import java.lang.Error

class BillboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBillboardBinding

    private val viewModel: BillboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBillboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launchWhenStarted {
            viewModel.billboardList.collect {
                when(it) {
                    is UIState.Loading -> {
                        showLoader()
                    }
                    is UIState.Success -> {
                        // TODO inicializar adaptador y mostrar la lista
                        hideLoader()
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