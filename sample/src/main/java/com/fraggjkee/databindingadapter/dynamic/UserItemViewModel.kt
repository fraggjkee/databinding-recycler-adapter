package com.fraggjkee.databindingadapter.dynamic

import com.fraggjkee.databindingadapter.User

class UserItemViewModel(val user: User) {

    lateinit var deleteBtnClickHandler: (user: User) -> Unit

    fun onDeleteButtonClick() {
        deleteBtnClickHandler(user)
    }
}