package com.swanky.rickandmortymvvm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.swanky.rickandmortymvvm.R
import com.swanky.rickandmortymvvm.databinding.ItemCharacterBinding
import com.swanky.rickandmortymvvm.fragments.CharactersFragmentDirections
import com.swanky.rickandmortymvvm.models.Character

class CharacterAdapter(private val characterList: ArrayList<Character>): RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    class ViewHolder(val dataBinding: ItemCharacterBinding) : RecyclerView.ViewHolder(dataBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val dataBinding = DataBindingUtil.inflate<ItemCharacterBinding>(LayoutInflater.from(parent.context), R.layout.item_character, parent, false)
        return ViewHolder(dataBinding)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characterList[position]

        holder.dataBinding.root.setOnClickListener {
            val action = CharactersFragmentDirections.actionCharactersFragmentToDetailsFragment(character.id)
            Navigation.findNavController(it).navigate(action)
        }

        // Set layout character variable
        holder.dataBinding.character = character
    }

    fun updateList(characterList: List<Character>) {
        this.characterList.clear()
        this.characterList.addAll(characterList)
        notifyDataSetChanged()
    }

}