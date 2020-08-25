package com.fraggjkee.databindingadapter.dynamic

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.fraggjkee.databindingadapter.R
import com.fraggjkee.databindingadapter.databinding.ActivityDynamicBinding

/**
 * This screen demonstrates the following use cases of the adapter:
 * - displaying a list of items (single view type)
 * - adding new items to the dataset
 * - removing items from the dataset
 * - dataset reordering
 * - basic click handling (based on lambdas)
 *
 * This sample demonstrates how to perform global list-level operations like adding or removing
 * new items. Refer to the sample in [com.fraggjkee.databindingadapter.dynamic_items] package
 * if you're interested updating individual items without touching the adapter and it's underlying
 * dataset.
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

        viewModel.toastMessage.observe(this) { message ->
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }
}
