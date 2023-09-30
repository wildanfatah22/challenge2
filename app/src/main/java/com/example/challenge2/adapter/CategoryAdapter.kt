package com.example.challenge2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge2.data.Category
import com.example.challenge2.databinding.ItemCategoriesBinding

class CategoryAdapter(
    private val list: List<Category>,
    private val categoryItemClickListener: CategoryItemClickListener
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {


    inner class ViewHolder(private val binding: ItemCategoriesBinding) : RecyclerView.ViewHolder(binding.root) {
        val icon = binding.categoryIcon
        val name = binding.categoryName

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val category = list[position]
                    categoryItemClickListener.onCategoryItemClicked(category)
                }
            }
        }
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

    interface CategoryItemClickListener {
        fun onCategoryItemClicked(category: Category)
    }
}