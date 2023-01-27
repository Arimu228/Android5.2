package com.example.android52.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android52.data.model.Characters
import com.example.android52.data.model.Result
import com.example.android52.databinding.ItemCharacterBinding

class CharacterAdapter(private val characters: Characters, private val onClick: (Int) -> Unit) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolderCharacter>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCharacter {
        return ViewHolderCharacter(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolderCharacter, position: Int) {
        holder.onBind(characters.results[position])
    }

    override fun getItemCount(): Int {
        return characters.results.size
    }

    fun getInfo(pos: Int): Result {
        return characters.results[pos]
    }

    inner class ViewHolderCharacter(private var binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun onBind(result: Result) {
            binding.title.text = result.name
            binding.description.text = result.species
            itemView.setOnClickListener {
                onClick(result.id)
            }

        }

    }
}





