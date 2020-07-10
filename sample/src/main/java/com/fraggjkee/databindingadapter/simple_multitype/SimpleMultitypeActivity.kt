package com.fraggjkee.databindingadapter.simple_multitype

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.fraggjkee.databindingadapter.R
import com.fraggjkee.databindingadapter.databinding.ActivitySimpleMultitypeBinding

/**
 * This screen demonstrates the following use cases of the adapter:
 * - displaying a static list of items (multiple view types).
 *
 * Refer to [com.fraggjkee.databindingadapter.dynamic.DynamicActivity] for more
 * advanced examples.
 */
class SimpleMultitypeActivity : AppCompatActivity() {

    private val viewModel: SimpleMultitypeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySimpleMultitypeBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_simple_multitype)
        binding.let {
            it.lifecycleOwner = this
            it.viewModel = this.viewModel
        }
    }
}