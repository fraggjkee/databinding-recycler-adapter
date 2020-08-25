package com.fraggjkee.databindingadapter.dynamic_items

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt

/**
 * This item-level view model demonstrates how to update individual UI elements within
 * a single RecyclerView row without modifying the backing dataset of the adapter.
 */
class FeedPostItemViewModel(postModel: FeedPost) {

    val postMessage = ObservableField<String>(postModel.text)
    val likesCount = ObservableInt(postModel.likesCount)
    val isLiked = ObservableBoolean(postModel.isLiked)

    fun toggleLike() {
        val isCurrentlyLiked = isLiked.get()
        val currentLikesCount = likesCount.get()
        isLiked.set(isCurrentlyLiked.not())
        likesCount.set(
            if (isCurrentlyLiked) currentLikesCount.dec()
            else currentLikesCount.inc()
        )
    }
}
