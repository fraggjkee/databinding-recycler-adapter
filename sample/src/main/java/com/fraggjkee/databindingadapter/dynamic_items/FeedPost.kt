package com.fraggjkee.databindingadapter.dynamic_items

data class FeedPost(
    val text: String,
    val likesCount: Int,
    val isLiked: Boolean
)

val DEMO_POSTS = listOf(
    FeedPost(
        text = "A very interesting post from your friend. A very interesting post from your friend. " +
                "A very interesting post from your friend.",
        likesCount = 12,
        isLiked = true
    ),
    FeedPost(
        text = "Yet another post from your friend. Yet another post from your friend. Yet another " +
                "post from your friend. Yet another post from your friend.",
        likesCount = 2,
        isLiked = false
    ),
    FeedPost(
        text = "And one more post from another friend of yours. And one more post from another " +
                "friend of yours. And one more post from another friend of yours.",
        likesCount = 2,
        isLiked = false
    )
)
