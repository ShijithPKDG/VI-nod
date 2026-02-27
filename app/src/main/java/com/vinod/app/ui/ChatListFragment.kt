package com.vinod.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinod.app.databinding.FragmentChatListBinding
import com.vinod.app.ui.adapter.ChatListAdapter

class ChatListFragment : Fragment() {
    private var _binding: FragmentChatListBinding? = null
    private val binding get() = _binding!!
    
    private val demoChats = listOf(
        "Akhil", "Pranav", "Shijith", "Vyshnav", "Manu",
        "Thejus", "Nived", "Navaneeth", "Achuttan", "Pachooty",
        "Appus", "Kunna", "Pookie", "Pooran"
    )
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatListBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = ChatListAdapter(demoChats) { name ->
            // Navigate to chat detail
            val fragment = ChatDetailFragment.newInstance(name)
            parentFragmentManager.beginTransaction()
                .replace(android.R.id.content, fragment)
                .addToBackStack(null)
                .commit()
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
