package com.jgbravo.tvbillboard.ui.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.jgbravo.tvbillboard.databinding.TvBillboardChipGroupBinding

class TVBillboardChipGroup @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ChipGroup(context, attrs, defStyleAttr) {

    private val binding: TvBillboardChipGroupBinding =
        TvBillboardChipGroupBinding.inflate(LayoutInflater.from(context))

    init {
        addView(binding.root)
        isSingleSelection = false
    }

    fun setNewList(list: List<String>) {
        list.forEach { title ->
            addChip(title)
        }
    }

    private fun addChip(label: String) {
        Chip(context).apply {
            id = View.generateViewId()
            text = label
            isClickable = true
            isCheckable = true
            //checkedIcon =
            isCheckedIconVisible = true
            chipSpacingHorizontal = 8
            addView(this)
        }
    }
}