package com.example.challenge2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge2.data.Category
import com.example.challenge2.databinding.ItemCategoriesBinding

class CategoryAdapter(private val list: List<Category>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemCategoriesBinding) : RecyclerView.ViewHolder(binding.root) {
        val icon = binding.categoryIcon
        val name = binding.categoryName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoriesBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user: Category = list[position]
        holder.icon.setImageResource(user.image)
        holder.name.text = user.name
    }

    override fun getItemCount(): Int {
        return list.size
    }
}