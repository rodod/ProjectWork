package com.example.projectwork.classes

import com.example.projectwork.classes.CFriends

data class CAccount(
    val accountID: Int,
    val name : String,
    val surname : String,
    val username : String,
    val profileImage : String,
    val steps : Int,
    val bio : String,
    val friends : List<CFriends>,
)
