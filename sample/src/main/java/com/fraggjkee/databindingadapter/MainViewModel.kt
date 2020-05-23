package com.fraggjkee.databindingadapter

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fraggjkee.recycleradapter.RecyclerItem

class MainViewModel : ViewModel() {

    private val _recyclerItems = MutableLiveData<List<RecyclerItem>>()
    val recyclerItems: LiveData<List<RecyclerItem>> = _recyclerItems

    init {
        _recyclerItems.value = loadUsers().map { it.toRecyclerItem() }

        Handler().postDelayed({
            _recyclerItems.value = loadUsers2().map { it.toRecyclerItem() }
        }, 3000)
    }

    private fun loadUsers(): List<User> =
        listOf(
            User(1, "Pyotr", "Tchaikovsky"),
            User(2, "Richard", "Wagner"),
            User(3, "Johannes", "Brahms"),
            User(4, "Franz", "Schubert"),
            User(5, "Giuseppe", "Verdi")
        )

    private fun loadUsers2(): List<User> =
        listOf(
            User(1, "Pyotr", "Tchaikovsky"),
            User(2, "Richard", "Wagner"),
            User(3, "Johannes", "Brahms"),
            User(5, "Giuseppe", "Verdi"),
            User(4, "Franz", "Schubert"),
            User(6, "Justin", "Bieber")
        )
}

private fun User.toRecyclerItem() = RecyclerItem(
    data = this,
    layoutId = R.layout.item_user,
    variableId = BR.user
)