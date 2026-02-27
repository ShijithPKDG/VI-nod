package com.vinod.app.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vinod.app.databinding.ItemChatListBinding

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
            
            // Different preview for group
            if (name.contains("Group")) {
                binding.messagePreview.text = "Group chat with everyone"
            } else {
                binding.messagePreview.text = "എന്താ മൈരാ വായിൽ ഇടണോ"
            }
            
            // Set first letter as avatar
            val firstLetter = if (name.contains("Group")) {
                "M"  // M for Myranmar
            } else {
                name.firstOrNull()?.uppercase() ?: "?"
            }
            binding.avatarText.text = firstLetter
            
            // Set color for avatar - special color for group
            val color = if (name.contains("Group")) {
                Color.parseColor("#1E88E5")  // Premium blue for group
            } else {
                Color.parseColor(colors[position % colors.size])
            }
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
