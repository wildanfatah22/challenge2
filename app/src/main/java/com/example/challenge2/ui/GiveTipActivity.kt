package com.example.challenge2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import com.example.challenge2.R
import com.example.challenge2.databinding.ActivityGiveTipBinding

class GiveTipActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGiveTipBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGiveTipBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.edtValueInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                calculateTip(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        binding.rgOption.setOnCheckedChangeListener { _, _ ->
            binding.edtValueInput.text?.let { text ->
                calculateTip(text.toString())
            }
        }

    }

    private fun calculateTip(billAmountText: String) {
        if (billAmountText.isNotEmpty()) {
            val billAmount = billAmountText.toDouble()
            val tipPercentage = when (binding.rgOption.checkedRadioButtonId) {
                binding.radio20.id -> 0.20
                binding.radio15.id -> 0.15
                binding.radio10.id -> 0.10
                else -> 0.0
            }
            val tipAmount = billAmount * tipPercentage
            val totalAmount = billAmount + tipAmount

            binding.result.text = getString(R.string.tip_result, tipAmount.toString(), totalAmount.toString())
        } else {
            binding.result.text = ""
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