package com.fraggjkee.databindingadapter.dynamic_items

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fraggjkee.databindingadapter.R
import com.fraggjkee.recycleradapter.BR
import com.fraggjkee.recycleradapter.RecyclerItem

class DynamicItemsViewModel : ViewModel() {

    private val _recyclerItems = MutableLiveData<List<RecyclerItem>>()
    val recyclerItems: LiveData<List<RecyclerItem>> = _recyclerItems

    init {
        _recyclerItems.value = DEMO_POSTS
            .map { FeedPostItemViewModel(it) }
            .map { it.toRecyclerItem() }
    }
}

private fun FeedPostItemViewModel.toRecyclerItem() = RecyclerItem(
    data = this,
    layoutId = R.layout.item_likable_post,
    variableId = BR.viewModel
)
