package com.testing.pixelwikiapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.testing.pixelwikiapp.databinding.FragmentFiguresBinding
import com.testing.pixelwikiapp.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Stop being crispy
        binding.imageView.drawable.isFilterBitmap = false
        binding.imageView2.drawable.isFilterBitmap = false
        binding.imageView3.drawable.isFilterBitmap = false
        binding.imageView4.drawable.isFilterBitmap = false
        binding.imageView5.drawable.isFilterBitmap = false
        binding.imageView6.drawable.isFilterBitmap = false
        binding.imageView7.drawable.isFilterBitmap = false
        binding.imageView8.drawable.isFilterBitmap = false

        // Menu clicks listeners
        binding.figuresBlock.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.to_figures)
        }

        binding.lightningBlock.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.to_lightning)
        }

        binding.coloringBlock.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.to_coloring)
        }
    }

}