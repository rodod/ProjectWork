package com.example.projectwork.classes

import java.util.Date

data class CMessage(
    val messageID : Int,
    val receiverID : Int,
    val senderID : Int,
    val frontPhoto : String,
    val retroPhoto : String,
    val steps : Int,
    val date : Date,
    val content : String,
)