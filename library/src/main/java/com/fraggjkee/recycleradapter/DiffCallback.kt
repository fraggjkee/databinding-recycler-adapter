package com.fraggjkee.recycleradapter

import androidx.recyclerview.widget.DiffUtil

internal class DiffCallback : DiffUtil.ItemCallback<RecyclerItem>() {

    override fun areItemsTheSame(
        oldItem: RecyclerItem,
        newItem: RecyclerItem
    ): Boolean {
        val oldData = oldItem.data
        val newData = newItem.data
        // Use appropriate comparator's method if both items implement the interface
        // and rely on the plain 'equals' otherwise
        return if (oldData is RecyclerItemComparator
            && newData is RecyclerItemComparator
        ) {
            oldData.isSameItem(newData)
        } else oldData == newData
    }

    override fun areContentsTheSame(
        oldItem: RecyclerItem,
        newItem: RecyclerItem
    ): Boolean {
        val oldData = oldItem.data
        val newData = newItem.data
        return if (oldData is RecyclerItemComparator
            && newData is RecyclerItemComparator
        ) {
            oldData.isSameContent(newData)
        } else oldData == newData
    }
}