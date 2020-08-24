package com.fraggjkee.databindingadapter.dynamic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fraggjkee.databindingadapter.BR
import com.fraggjkee.databindingadapter.DEMO_USERS
import com.fraggjkee.databindingadapter.R
import com.fraggjkee.databindingadapter.User
import com.fraggjkee.recycleradapter.RecyclerItem

class DynamicViewModel : ViewModel() {

    private val _recyclerItems = MutableLiveData<List<RecyclerItem>>()
    val recyclerItems: LiveData<List<RecyclerItem>> = _recyclerItems

    // Real-world apps should use SingleLiveData instead. RxJava / Coroutines could also work
    // better for one-time event streams.
    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> = _toastMessage

    init {
        _recyclerItems.value = loadUsers()
            .map { createUserItemViewModel(it) }
            .map { it.toRecyclerItem() }
    }

    private fun createUserItemViewModel(user: User): UserItemViewModel {
        return UserItemViewModel(user).apply {
            itemClickHandler = { user -> showClickMessage(user) }
            deleteBtnClickHandler = { user -> deleteUser(user) }
        }
    }

    private fun showClickMessage(user: User) {
        _toastMessage.postValue(
            "${user.firstName} ${user.lastName} is clicked"
        )
    }

    private fun deleteUser(user: User) {
        val items = recyclerItems.value.orEmpty()
        val index = items.map { it.data }
            .filterIsInstance<UserItemViewModel>()
            .indexOfFirst { it.user == user }
        if (index != -1) {
            _recyclerItems.value = items.toMutableList().apply { removeAt(index) }
        }
    }

    private fun loadUsers(): List<User> = DEMO_USERS

    fun onAddClick() {

        fun generateNewUser(): User {
            val id = recyclerItems.value.orEmpty().size.inc()
            return User(id.toLong(), "First Name #$id", "Last Name #$id")
        }

        val user = generateNewUser()
        val newItem = createUserItemViewModel(user).toRecyclerItem()
        _recyclerItems.value = recyclerItems.value.orEmpty() + newItem
    }

    fun onShuffleClick() {
        _recyclerItems.value = recyclerItems.value.orEmpty().shuffled()
    }
}

private fun UserItemViewModel.toRecyclerItem() = RecyclerItem(
    data = this,
    layoutId = R.layout.item_user_deletable,
    variableId = BR.viewModel
)
