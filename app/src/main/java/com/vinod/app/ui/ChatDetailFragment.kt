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
        
        // Demo messages
        val demoMessages = listOf(
            Pair("Hey! How are you?", false),
            Pair("I'm good! How about you?", true),
            Pair("Doing great! Want to hang out?", false),
            Pair("Sure! When?", true),
            Pair("How about tomorrow?", false)
        )
        
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = MessageAdapter(demoMessages)
        
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
