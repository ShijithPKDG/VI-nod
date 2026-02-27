package com.vinod.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinod.app.data.model.Message
import com.vinod.app.data.repository.MockAuthRepository
import com.vinod.app.databinding.FragmentChatBinding
import com.vinod.app.ui.adapter.MessageAdapter
import com.vinod.app.viewmodel.ChatViewModel

class ChatFragment : Fragment() {
    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ChatViewModel by viewModels()
    private val args: ChatFragmentArgs by navArgs()
    private lateinit var adapter: MessageAdapter
    private lateinit var authRepository: MockAuthRepository
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        authRepository = MockAuthRepository(requireContext())
        binding.tvGroupName.text = args.groupName
        
        setupRecyclerView()
        setupObservers()
        setupClickListeners()
        
        viewModel.loadMessages(args.groupId)
    }
    
    private fun setupRecyclerView() {
        val currentUserId = authRepository.getCurrentUser()?.uid ?: ""
        adapter = MessageAdapter(currentUserId)
        binding.recyclerMessages.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerMessages.adapter = adapter
    }
    
    private fun setupObservers() {
        viewModel.messages.observe(viewLifecycleOwner) { messages ->
            adapter.submitList(messages)
            if (messages.isNotEmpty()) {
                binding.recyclerMessages.scrollToPosition(messages.size - 1)
            }
        }
    }
    
    private fun setupClickListeners() {
        binding.btnSend.setOnClickListener {
            val text = binding.etMessage.text.toString()
            if (text.isNotBlank()) {
                val currentUser = authRepository.getCurrentUser() ?: return@setOnClickListener
                val message = Message(
                    groupId = args.groupId,
                    senderId = currentUser.uid,
                    senderName = currentUser.name,
                    text = text
                )
                viewModel.sendMessage(message)
                binding.etMessage.text?.clear()
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
