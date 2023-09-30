package com.example.challenge2.data

data class Transaction(
    val id: Int,
    val transactionName: String,
    val userName: String,
    val transactionSystem: String,
    val transactionValue: String,
    val date: String,
    val message: String
)
