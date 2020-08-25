package com.fraggjkee.databindingadapter.dynamic_items

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.fraggjkee.databindingadapter.R
import com.fraggjkee.databindingadapter.databinding.ActivityDynamicItemsBinding

/**
 * This screen demonstrates the following use cases of the adapter:
 * - displaying a list of items (single view type)
 * - dynamic updates within individual adapter items without updating the entire dataset
 * - basic click handling (based on lambdas).
 *
 * Unlike the sample located in [com.fraggjkee.databindingadapter.dynamic] package, this example
 * is about the case when you need to make some changes within individual rows without updating
 * the underlying dataset. Let'say, you need to mark some "like" icon as filled in response
 * to some user action. It would be an overkill to trigger adapter's dataset changes and this
 * sample demonstrates how this can be achieved using the standard components of the DataBinding
 * framework.
 *
 * Take a look at the "dynamic" sample if you're interested in list-level changes like adding or
 * removing new items.
 */
class DynamicItemsActivity : AppCompatActivity() {

    private val viewModel: DynamicItemsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDynamicItemsBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_dynamic_items)
        binding.let {
            it.lifecycleOwner = this
            it.viewModel = this.viewModel
        }
    }
}
