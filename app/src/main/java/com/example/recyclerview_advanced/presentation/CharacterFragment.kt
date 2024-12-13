package com.example.recyclerview_advanced.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.recyclerview_advanced.databinding.FragmentCharacterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class CharacterFragment : Fragment() {

    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CharacterPagedListViewModel by viewModels()
    private val pagedAdapter = CharacterPagedListAdapter { character -> onItemClick(character) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listItem.adapter = pagedAdapter

        viewModel.pagedCharacter.onEach {
            Log.d("CharacterFragment", "CharacterFragment   viewModel.pagedCharacter.onEach $it")
            pagedAdapter.submitData(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun onItemClick(character: com.example.recyclerview_advanced.api.Character) {

    }

    override fun onDestroyView() {
        Log.d("CharacterFragment", "CharacterFragment DestroyView")
        super.onDestroyView()
        _binding = null
    }

}