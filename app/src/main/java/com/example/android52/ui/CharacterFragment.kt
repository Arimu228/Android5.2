package com.example.android52.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android52.R
import com.example.android52.data.RemoteRepository
import com.example.android52.data.model.Characters
import com.example.android52.databinding.FragmentFirstBinding


class CharacterFragment : Fragment() {
    private val repository = RemoteRepository()
    private lateinit var binding: FragmentFirstBinding
    private lateinit var adapter: CharacterAdapter
    private var page = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        getCharacters()
        listener()

        return binding.root
    }

    private fun listener() {
        binding.fabNext.setOnClickListener {
            getCharacters()
            ++page

        }
    }

//    swipeRefreshLayout


    private fun getCharacters() {
        repository.getCharacters(page,this::onSuccess, this::onFailure)
    }

    private fun onCLick(id: Int) {
        findNavController().navigate(R.id.characterDetailFragment)
        findNavController().navigate(R.id.characterFragment)
    }

    private fun onSuccess(characters: Characters) {


        binding.rvMain.adapter = CharacterAdapter(characters, this::onCLick)
        binding.rvMain.adapter = adapter



    }


    private fun onFailure(message: String) {
        Log.e("olo", "onFailure: $message")
    }


}