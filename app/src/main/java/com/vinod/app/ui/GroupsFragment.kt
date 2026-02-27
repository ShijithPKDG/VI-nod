package com.vinod.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.textfield.TextInputEditText
import com.vinod.app.R
import com.vinod.app.data.repository.MockAuthRepository
import com.vinod.app.databinding.FragmentGroupsBinding
import com.vinod.app.ui.adapter.GroupAdapter
import com.vinod.app.viewmodel.GroupState
import com.vinod.app.viewmodel.GroupViewModel

class GroupsFragment : Fragment() {
    private var _binding: FragmentGroupsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GroupViewModel by viewModels()
    private lateinit var adapter: GroupAdapter
    private lateinit var authRepository: MockAuthRepository
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGroupsBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        authRepository = MockAuthRepository(requireContext())
        
        setupRecyclerView()
        setupObservers()
        setupClickListeners()
        
        val userId = authRepository.getCurrentUser()?.uid ?: return
        viewModel.loadUserGroups(userId)
    }
    
    private fun setupRecyclerView() {
        adapter = GroupAdapter { group ->
            val action = GroupsFragmentDirections.actionGroupsToChat(
                group.groupId,
                group.name
            )
            findNavController().navigate(action)
        }
        binding.recyclerGroups.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerGroups.adapter = adapter
    }
    
    private fun setupObservers() {
        viewModel.userGroups.observe(viewLifecycleOwner) { groups ->
            adapter.submitList(groups)
        }
        
        viewModel.groupState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is GroupState.GroupCreated -> {
                    Toast.makeText(requireContext(), "Group created! Code: ${state.group.inviteCode}", Toast.LENGTH_LONG).show()
                }
                is GroupState.GroupJoined -> {
                    Toast.makeText(requireContext(), "Joined ${state.group.name}", Toast.LENGTH_SHORT).show()
                }
                is GroupState.Error -> {
                    Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                }
                else -> {}
            }
        }
    }
    
    private fun setupClickListeners() {
        binding.fabCreateGroup.setOnClickListener {
            showCreateGroupDialog()
        }
        
        binding.fabJoinGroup.setOnClickListener {
            showJoinGroupDialog()
        }
    }
    
    private fun showCreateGroupDialog() {
        val input = TextInputEditText(requireContext())
        input.hint = "Group Name"
        
        AlertDialog.Builder(requireContext())
            .setTitle("Create Group")
            .setView(input)
            .setPositiveButton("Create") { _, _ ->
                val name = input.text.toString()
                if (name.isNotBlank()) {
                    val userId = authRepository.getCurrentUser()?.uid ?: return@setPositiveButton
                    viewModel.createGroup(name, userId)
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
    
    private fun showJoinGroupDialog() {
        val input = TextInputEditText(requireContext())
        input.hint = "Invite Code"
        
        AlertDialog.Builder(requireContext())
            .setTitle("Join Group")
            .setView(input)
            .setPositiveButton("Join") { _, _ ->
                val code = input.text.toString()
                if (code.isNotBlank()) {
                    val userId = authRepository.getCurrentUser()?.uid ?: return@setPositiveButton
                    viewModel.joinGroup(code, userId)
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
