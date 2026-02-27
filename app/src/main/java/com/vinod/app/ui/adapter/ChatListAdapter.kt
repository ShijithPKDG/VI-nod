package com.vinod.app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vinod.app.databinding.ItemChatListBinding

class ChatListAdapter(
    private val names: List<String>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<ChatListAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemChatListBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        
        fun bind(name: String) {
            binding.nameText.text = name
            binding.messagePreview.text = "Hey! How are you?"
            binding.root.setOnClickListener { onItemClick(name) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemChatListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(names[position])
    }

    override fun getItemCount() = names.size
}
