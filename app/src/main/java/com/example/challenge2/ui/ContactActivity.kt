package com.example.challenge2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.example.challenge2.R
import com.example.challenge2.adapter.ContactAdapter
import com.example.challenge2.adapter.TransactionAdapter
import com.example.challenge2.data.Contact
import com.example.challenge2.data.TransactionItem
import com.example.challenge2.databinding.ActivityContactBinding
import com.example.challenge2.databinding.ActivityMainBinding

class ContactActivity : AppCompatActivity(), ContactAdapter.ContactItemClickListener {
    private lateinit var binding: ActivityContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindContact()
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun bindContact() {
        val rvListUser = binding.rvListUser
        val contact: List<Contact> = listOf(
            Contact(
                id = 1,
                name = "Talitha Alda Z",
                phoneNumber = "140451402214069",
                photoId = R.drawable.avatar
            ),
        )
        val contactAdapter = ContactAdapter(contact, this)
        rvListUser.adapter = contactAdapter
    }

    override fun onContactItemClicked(contact: Contact) {
        when (contact.id) {
            1 -> {
                val intent = Intent(this@ContactActivity, GiveTipActivity::class.java)
                startActivity(intent)
            }
            else -> {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}