package com.example.android52.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android52.R
import com.example.android52.data.RemoteRepository
import com.example.android52.data.model.Characters
import com.example.android52.databinding.FragmentCharacterBinding


class CharacterFragment : Fragment() {
    private val repository = RemoteRepository()
    private lateinit var binding: FragmentCharacterBinding
    private lateinit var adapter: CharacterAdapter
    private var page = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentCharacterBinding.inflate(LayoutInflater.from(context),container,false)
        getCharacters()
        listener()
        refreshLayout()
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
        val result = adapter.getInfo(id)
        findNavController().navigate(R.id.characterDetailFragment, bundleOf("key" to result))

    }

    private fun onSuccess(characters: Characters) {
        adapter = CharacterAdapter(characters, this::onCLick)
        binding.rv.adapter = adapter
    }


    private fun onFailure(message: String) {
        Log.e("olo", "onFailure: $message")
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun refreshLayout() {
        binding.swipeRefresh.setOnRefreshListener {
            getCharacters()
            ++page
            (Handler()).postDelayed({ binding.swipeRefresh.isRefreshing = false }, 5000)
            binding.swipeRefresh.setColorSchemeResources(
                R.color.blue_dark,
                R.color.orange,
                R.color.purple_200,
                R.color.black
            )
        }
    }


}