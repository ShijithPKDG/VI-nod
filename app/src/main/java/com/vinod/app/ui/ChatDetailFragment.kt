package com.vinod.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinod.app.databinding.FragmentChatDetailBinding
import com.vinod.app.ui.adapter.MessageAdapter

class ChatDetailFragment : Fragment() {
    private var _binding: FragmentChatDetailBinding? = null
    private val binding get() = _binding!!
    private var chatName: String = ""
    
    companion object {
        private const val ARG_NAME = "name"
        
        fun newInstance(name: String) = ChatDetailFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_NAME, name)
            }
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        chatName = arguments?.getString(ARG_NAME) ?: ""
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.toolbar.title = chatName
        binding.toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
        
        // Demo messages - first message from server side
        val demoMessages = listOf(
            Pair("എന്താ മൈരാ വായിൽ ഇടണോ", false),  // Server message (received)
            Pair("Hey! How are you?", true),
            Pair("I'm good! Thanks for asking", false),
            Pair("Want to catch up later?", true),
            Pair("Sure! Let me know when", false)
        )
        
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = MessageAdapter(demoMessages)
        
        // Scroll to bottom to show latest messages
        binding.recyclerView.scrollToPosition(demoMessages.size - 1)
        
        binding.sendButton.setOnClickListener {
            val text = binding.messageInput.text.toString()
            if (text.isNotEmpty()) {
                binding.messageInput.text?.clear()
                // In real app, send message here
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
