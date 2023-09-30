package com.example.challenge2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.challenge2.R
import com.example.challenge2.adapter.CategoryAdapter
import com.example.challenge2.adapter.TransactionAdapter
import com.example.challenge2.data.Category
import com.example.challenge2.data.TransactionItem
import com.example.challenge2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CategoryAdapter.CategoryItemClickListener {
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
        val transactionItems: List<TransactionItem> = listOf(
            TransactionItem(
                id = 1,
                transactionName = "Tip",
                userName = "John Doe",
                date = "2023-09-18",
                message = "Thank you!",
                transactionSystem = "-",
                transactionValue = "Rp25.000",
            ),
            TransactionItem(
                id = 2,
                transactionName = "Transfer",
                userName = "Alice Smith",
                date = "2023-09-17",
                message = "Debt",
                transactionSystem = "-",
                transactionValue = "Rp250.000",
            ),
            TransactionItem(
                id = 3,
                transactionName = "Transfer",
                userName = "Megawati",
                date = "2023-09-17",
                message = "Buat bayar buzzer ya",
                transactionSystem = "+",
                transactionValue = "Rp1.250.000",
            ),
        )
        val transactionAdapter = TransactionAdapter(transactionItems)
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

        val categoryAdapter = CategoryAdapter(category, this)
        rvKategori.adapter = categoryAdapter
    }

    override fun onCategoryItemClicked(category: Category) {
        when (category.id) {
            1 -> {
                // Tambahkan kode untuk berpindah ke activity Transfer
                Toast.makeText(this@MainActivity, "Feature not yet available", Toast.LENGTH_LONG).show()
            }
            2 -> {
                // Tambahkan kode untuk berpindah ke activity Give Tip
                val intent = Intent(this@MainActivity, ContactActivity::class.java)
                startActivity(intent)
            }
            3 -> {
                // Tambahkan kode untuk berpindah ke activity Top Up
                Toast.makeText(this@MainActivity, "Feature not yet available", Toast.LENGTH_LONG).show()
            }
            else -> {
                // Tindakan yang akan diambil jika kategori tidak dikenali
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }

}