package com.example.calculator.feature.presentation.ui.add

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calculator.R
import com.example.calculator.databinding.FragmentCreateNewItemBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateNewItemFragment : Fragment(R.layout.fragment_create_new_item) {

    private var _binding: FragmentCreateNewItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateNewItemBinding.inflate(inflater, container, false)

        Log.d("AddFragment", "AddFragment View Created")

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}