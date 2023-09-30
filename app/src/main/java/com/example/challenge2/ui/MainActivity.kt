package com.example.challenge2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.challenge2.R
import com.example.challenge2.adapter.CategoryAdapter
import com.example.challenge2.adapter.TransactionAdapter
import com.example.challenge2.data.Category
import com.example.challenge2.data.Transaction
import com.example.challenge2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindTransaction()
        bindCategory()

    }

    private fun bindTransaction(){
        val rvTransaction = binding.rvTransaction
        val transaction: List<Transaction> = listOf(
            Transaction(
                id = 1,
                transactionName = "Tip",
                userName = "John Doe",
                date = "2023-09-18",
                message = "Thank you!",
                transactionSystem = "-",
                transactionValue = "Rp25.000",
            ),
            Transaction(
                id = 2,
                transactionName = "Transfer",
                userName = "Alice Smith",
                date = "2023-09-17",
                message = "Debt",
                transactionSystem = "-",
                transactionValue = "Rp250.000",
            ),
        )
        val transactionAdapter = TransactionAdapter(transaction)
        rvTransaction.adapter = transactionAdapter
    }

    private fun bindCategory(){
        val rvKategori = binding.rvCategory
        val category: List<Category> = listOf(
            Category(
                id = 1,
                name = "Transfer",
                image = R.drawable.baseline_attach_money_24
            ),
            Category(
                id = 2,
                name = "Give Tip",
                image = R.drawable.baseline_money_24
            ),
            Category(
                id = 3,
                name = "Top Up",
                image = R.drawable.baseline_shortcut_24
            )
        )

        val categoryAdapter = CategoryAdapter(category)
        rvKategori.adapter = categoryAdapter
    }

}