package com.example.android52.ui

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android52.R
import com.example.android52.data.model.Characters
import com.example.android52.data.model.Result
import com.example.android52.databinding.ItemCharacterBinding

class CharacterAdapter(private val characters: Characters, private val onClick: (Int) -> Unit) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {
    lateinit var binding: ItemCharacterBinding


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            binding = ItemCharacterBinding.bind(itemView)
        }
        fun onBind(result: Result) {
            binding.title.text = result.name
            binding.description.text = result.species

            itemView.setOnClickListener {
                onClick(result.id)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(characters.results[position])


    }

    override fun getItemCount() = characters.results.size
}





