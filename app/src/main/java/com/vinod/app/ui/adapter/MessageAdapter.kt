package com.vinod.app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vinod.app.databinding.ItemMessageReceivedBinding
import com.vinod.app.databinding.ItemMessageSentBinding
import java.text.SimpleDateFormat
import java.util.*

class MessageAdapter(
    private val messages: List<Pair<String, Boolean>>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_SENT = 1
        private const val VIEW_TYPE_RECEIVED = 2
    }
    
    private val timeFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())

    inner class SentViewHolder(private val binding: ItemMessageSentBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: String) {
            binding.tvMessage.text = message
            binding.tvTime.text = timeFormat.format(Date())
        }
    }

    inner class ReceivedViewHolder(private val binding: ItemMessageReceivedBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: String) {
            binding.tvMessage.text = message
            binding.tvTime.text = timeFormat.format(Date())
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (messages[position].second) VIEW_TYPE_SENT else VIEW_TYPE_RECEIVED
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_SENT) {
            val binding = ItemMessageSentBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            SentViewHolder(binding)
        } else {
            val binding = ItemMessageReceivedBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            ReceivedViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = messages[position].first
        when (holder) {
            is SentViewHolder -> holder.bind(message)
            is ReceivedViewHolder -> holder.bind(message)
        }
    }

    override fun getItemCount() = messages.size
}
