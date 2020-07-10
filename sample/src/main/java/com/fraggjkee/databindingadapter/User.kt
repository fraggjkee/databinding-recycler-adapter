package com.fraggjkee.databindingadapter

data class User(
    val id: Long,
    val firstName: String,
    val lastName: String
)

val DEMO_USERS: List<User> =
    listOf(
        User(
            1,
            "Pyotr",
            "Tchaikovsky"
        ),
        User(2, "Richard", "Wagner"),
        User(
            3,
            "Johannes",
            "Brahms"
        ),
        User(4, "Franz", "Schubert"),
        User(5, "Giuseppe", "Verdi")
    )