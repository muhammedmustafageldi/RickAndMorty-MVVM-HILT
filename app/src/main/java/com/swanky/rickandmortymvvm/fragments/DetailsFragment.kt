package com.swanky.rickandmortymvvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.swanky.rickandmortymvvm.R
import com.swanky.rickandmortymvvm.databinding.FragmentDetailsBinding
import com.swanky.rickandmortymvvm.viewmodels.DetailsFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private lateinit var dataBinding: FragmentDetailsBinding
    private lateinit var viewModel: DetailsFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        dataBinding.master = this
        viewModel = ViewModelProvider(this)[DetailsFragmentViewModel::class.java]
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeLiveData()

        arguments?.let {
            val characterId = DetailsFragmentArgs.fromBundle(it).characterId
            viewModel.getCharacterById(characterId)
        }
    }

    private fun observeLiveData(){
        viewModel.characterLiveData.observe(viewLifecycleOwner) { character ->
            character?.let {
                dataBinding.character = character
            } ?: run {
                // Handle the case where character is null
                Toast.makeText(requireContext(), "Character not found", Toast.LENGTH_SHORT).show()
            }

        }
    }
}