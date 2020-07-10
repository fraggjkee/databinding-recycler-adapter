package com.fraggjkee.databindingadapter.simple

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fraggjkee.databindingadapter.BR
import com.fraggjkee.databindingadapter.DEMO_USERS
import com.fraggjkee.databindingadapter.R
import com.fraggjkee.databindingadapter.User
import com.fraggjkee.recycleradapter.RecyclerItem

class SimpleViewModel : ViewModel() {

    private val _recyclerItems = MutableLiveData<List<RecyclerItem>>()
    val recyclerItems: LiveData<List<RecyclerItem>> = _recyclerItems

    init {
        _recyclerItems.value = loadUsers().map { it.toRecyclerItem() }
    }

    private fun loadUsers(): List<User> = DEMO_USERS
}

private fun User.toRecyclerItem() = RecyclerItem(
    data = this,
    layoutId = R.layout.item_user,
    variableId = BR.user
)