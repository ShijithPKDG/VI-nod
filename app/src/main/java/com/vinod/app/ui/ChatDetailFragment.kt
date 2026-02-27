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
    private val messagesList = mutableListOf<Pair<String, Boolean>>()
    private lateinit var adapter: MessageAdapter
    
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
        
        // Only show the Malayalam message initially (from server/other person)
        messagesList.add(Pair("എന്താ മൈരാ വായിൽ ഇടണോ", false))
        
        adapter = MessageAdapter(messagesList)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        
        // Scroll to bottom
        binding.recyclerView.scrollToPosition(messagesList.size - 1)
        
        binding.sendButton.setOnClickListener {
            val text = binding.messageInput.text.toString().trim()
            if (text.isNotEmpty()) {
                // Add user's message
                messagesList.add(Pair(text, true))
                adapter.notifyItemInserted(messagesList.size - 1)
                binding.recyclerView.scrollToPosition(messagesList.size - 1)
                
                // Clear input
                binding.messageInput.text?.clear()
                
                // Simulate response after a short delay
                binding.recyclerView.postDelayed({
                    val responses = listOf(
                        "Got it!",
                        "Sure thing!",
                        "Okay",
                        "Alright",
                        "👍"
                    )
                    messagesList.add(Pair(responses.random(), false))
                    adapter.notifyItemInserted(messagesList.size - 1)
                    binding.recyclerView.scrollToPosition(messagesList.size - 1)
                }, 1000)
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
