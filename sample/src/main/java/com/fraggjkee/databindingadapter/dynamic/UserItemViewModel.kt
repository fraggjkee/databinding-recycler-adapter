package com.fraggjkee.databindingadapter.dynamic

import com.fraggjkee.databindingadapter.User

/**
 * Hint: consider merging multiple click listeners/events into a single sealed class in Kotlin:
 *
 * ```
 * sealed class Click {
 *     class Item(val user: User) : Click()
 *     class DeleteButton(val user: User) : Click()
 *     // etc.
 * }
 * ```
 *
 * This may help to reduce the amount of variables similar to [itemClickHandler]. Using this
 * approach, you could use single handler for all possible situations -
 * `var clickListener: (click: Click) -> Unit`.
 *
 * Please also note that lambda-based communication is just the simplest option. Production apps
 * can use more advanced things like RxJava (Subjects & Observables). Coroutines also provide
 * built-in tools similar to RxJava streams in Flow package.
 */
class UserItemViewModel(val user: User) {

    lateinit var itemClickHandler: (user: User) -> Unit
    lateinit var deleteBtnClickHandler: (user: User) -> Unit

    fun onItemClick() {
        itemClickHandler(user)
    }

    fun onDeleteButtonClick() {
        deleteBtnClickHandler(user)
    }
}
