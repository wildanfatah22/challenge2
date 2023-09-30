package com.example.challenge2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge2.data.Transaction
import com.example.challenge2.databinding.ItemTransactionBinding

class TransactionAdapter(private val list: List<Transaction>) : RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemTransactionBinding) : RecyclerView.ViewHolder(binding.root) {
        val transaction = binding.tvTransaction
        val name = binding.tvUser
        val date = binding.tvDate
        val msg = binding.tvMessage
        val system = binding.tvTransactionSystem
        val value = binding.tvTransactionValue
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTransactionBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user: Transaction = list[position]
        holder.transaction.text = user.transactionName
        holder.name.text = user.userName
        holder.date.text = user.date
        holder.msg.text = user.message
        holder.system.text = user.transactionSystem
        holder.value.text = user.transactionValue
    }

    override fun getItemCount(): Int {
        return list.size
    }

}