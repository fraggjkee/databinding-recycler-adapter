package com.fraggjkee.databindingadapter.simple

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.fraggjkee.databindingadapter.R
import com.fraggjkee.databindingadapter.databinding.ActivitySimpleBinding

/**
 * This screen demonstrates the following use cases of the adapter:
 * - displaying a static list of items (single view type).
 *
 * Refer to [com.fraggjkee.databindingadapter.dynamic.DynamicActivity] for more
 * advanced examples.
 */
class SimpleActivity : AppCompatActivity() {

    private val viewModel: SimpleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySimpleBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_simple)
        binding.let {
            it.lifecycleOwner = this
            it.viewModel = this.viewModel
        }
    }
}