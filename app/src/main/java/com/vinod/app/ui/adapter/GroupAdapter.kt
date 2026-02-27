package com.vinod.app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vinod.app.data.model.Group
import com.vinod.app.databinding.ItemGroupBinding

class GroupAdapter(
    private val onGroupClick: (Group) -> Unit
) : ListAdapter<Group, GroupAdapter.GroupViewHolder>(GroupDiffCallback()) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val binding = ItemGroupBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return GroupViewHolder(binding, onGroupClick)
    }
    
    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    
    class GroupViewHolder(
        private val binding: ItemGroupBinding,
        private val onGroupClick: (Group) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(group: Group) {
            binding.tvGroupName.text = group.name
            binding.tvMemberCount.text = "${group.members.size} members"
            binding.tvInviteCode.text = "Code: ${group.inviteCode}"
            binding.root.setOnClickListener { onGroupClick(group) }
        }
    }
}

class GroupDiffCallback : DiffUtil.ItemCallback<Group>() {
    override fun areItemsTheSame(oldItem: Group, newItem: Group): Boolean {
        return oldItem.groupId == newItem.groupId
    }
    
    override fun areContentsTheSame(oldItem: Group, newItem: Group): Boolean {
        return oldItem == newItem
    }
}
