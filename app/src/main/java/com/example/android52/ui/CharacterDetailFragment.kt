package com.example.android52.ui

import android.os.Bundle
import android.security.identity.ResultData
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android52.R
import com.example.android52.databinding.FragmentSecondBinding


class CharacterDetailFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private lateinit var result:com.example.android52.data.model.Result

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        info()
        initViews()
        return inflater.inflate(R.layout.fragment_second, container, false)
    }




    private fun info() {
        if (arguments!=null){
            (arguments?.getSerializable("key") as Result<*>).also { result }
            binding.tvName.text = result.name
            binding.tvSpecie2.text = result.species
            binding.tvGender2.text = result.gender
            binding.tvStatus2.text = result.status
            binding.tvOrigin2.text = result.origin.name
            binding.tvType2.text = result.type
            binding.tvLocation2.text =result.location.name
//            binding.imageView.glide(result.image)
        }}
    private fun initViews() {
        binding.tvGoBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}