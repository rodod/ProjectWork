package com.example.projectwork.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectwork.databinding.FragmentAccountBinding

class UserAccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}