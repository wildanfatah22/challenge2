package com.example.challenge2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge2.data.Contact
import com.example.challenge2.databinding.ItemContactBinding

class ContactAdapter(
    private val list: List<Contact>,
    private val contactItemClickListener: ContactItemClickListener
) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {


    inner class ViewHolder(private val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {
        val photo = binding.photo
        val name = binding.tvName
        val number = binding.tvNumber

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val contact = list[position]
                    contactItemClickListener.onContactItemClicked(contact)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemContactBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user: Contact = list[position]
        holder.photo.setImageResource(user.photoId)
        holder.name.text = user.name
        holder.number.text = user.phoneNumber
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface ContactItemClickListener {
        fun onContactItemClicked(contact: Contact)
    }
}