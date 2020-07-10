package com.fraggjkee.databindingadapter.dynamic

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.fraggjkee.databindingadapter.R
import com.fraggjkee.databindingadapter.databinding.ActivityDynamicBinding

/**
 * This screen demonstrates the following use cases of the adapter:
 * - displaying a list of items (single view type)
 * - adding new items to the dataset
 * - removing items from the dataset
 * - dataset reordering
 * - primitive click handling (based on lambdas)
 */
class DynamicActivity : AppCompatActivity() {

    private val viewModel: DynamicViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDynamicBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_dynamic)
        binding.let {
            it.lifecycleOwner = this
            it.viewModel = this.viewModel
        }
    }
}