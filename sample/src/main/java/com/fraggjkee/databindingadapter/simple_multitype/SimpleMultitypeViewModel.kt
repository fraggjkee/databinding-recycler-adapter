package com.fraggjkee.databindingadapter.simple_multitype

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fraggjkee.databindingadapter.BR
import com.fraggjkee.databindingadapter.DEMO_USERS
import com.fraggjkee.databindingadapter.R
import com.fraggjkee.databindingadapter.User
import com.fraggjkee.recycleradapter.RecyclerItem

class SimpleMultitypeViewModel : ViewModel() {

    private val _recyclerItems = MutableLiveData<List<RecyclerItem>>()
    val recyclerItems: LiveData<List<RecyclerItem>> = _recyclerItems

    init {
        val users = loadUsers()
        val admins = loadAdmins()
        _recyclerItems.value =
            users.map { it.toUserRecyclerItem() } + admins.map { it.toAdminRecyclerItem() }
    }

    private fun loadUsers(): List<User> = DEMO_USERS

    private fun loadAdmins(): List<User> = listOf(
        User(
            id = 444,
            firstName = "Admin",
            lastName = "#1"
        ),
        User(
            id = 555,
            firstName = "Admin",
            lastName = "#2"
        )
    )
}

// This particular example uses a single data class (User) and converts it into two different
// RecyclerItems, the key difference hides in 'layoutId' parameter, i.e. different layouts are
// used to render same object. This approach is not mandatory, it's perfectly fine to use different
// objects like "User" and "Admin" in this case, the only requirement here is that every type of
// RecyclerItem must use a unique R.layout.xxx parameter assigned to 'layoutId' variable.
private fun User.toUserRecyclerItem() = RecyclerItem(
    data = this,
    layoutId = R.layout.item_user,
    variableId = BR.user
)

private fun User.toAdminRecyclerItem() = RecyclerItem(
    data = this,
    layoutId = R.layout.item_admin,
    variableId = BR.user
)