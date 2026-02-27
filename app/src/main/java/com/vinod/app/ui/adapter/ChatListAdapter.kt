package com.vinod.app.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vinod.app.databinding.ItemChatListBinding
import kotlin.random.Random

class ChatListAdapter(
    private val names: List<String>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<ChatListAdapter.ViewHolder>() {

    private val colors = listOf(
        "#FF6B6B", "#4ECDC4", "#45B7D1", "#FFA07A", "#98D8C8",
        "#F7DC6F", "#BB8FCE", "#85C1E2", "#F8B739", "#52B788"
    )

    inner class ViewHolder(private val binding: ItemChatListBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        
        fun bind(name: String, position: Int) {
            binding.nameText.text = name
            binding.messagePreview.text = "Hey! How are you?"
            
            // Set first letter as avatar
            val firstLetter = name.firstOrNull()?.uppercase() ?: "?"
            binding.avatarText.text = firstLetter
            
            // Set random color for avatar
            val color = Color.parseColor(colors[position % colors.size])
            binding.avatarText.setBackgroundColor(color)
            
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
        holder.bind(names[position], position)
    }

    override fun getItemCount() = names.size
}
