package com.decagon.n26_p6.features.presentation.viewcontroller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.decagon.n26_p6.R
import com.decagon.n26_p6.common.utils.Resource
import com.decagon.n26_p6.common.utils.log
import com.decagon.n26_p6.databinding.FragmentPresentationBinding
import com.decagon.n26_p6.features.model.data.DataSafe
import com.decagon.n26_p6.features.presentation.viewmodel.DataViewModel
import kotlinx.coroutines.NonDisposableHandle.parent

class PresentationFragment : Fragment() {

    lateinit var binding: FragmentPresentationBinding
    private val dataViewModel : DataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPresentationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
    }

    private fun initObservers() {
        dataViewModel.data.observe(viewLifecycleOwner , {
            when (it) {
                is Resource.Success<DataSafe> -> { }
                is Resource.Error -> { }
                is Resource.Loading -> { }
            }
        })
    }
}