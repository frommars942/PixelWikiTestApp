package com.testing.pixelwikiapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.testing.pixelwikiapp.databinding.FragmentFiguresBinding
import com.testing.pixelwikiapp.databinding.FragmentLightningBinding
import com.testing.pixelwikiapp.databinding.FragmentMenuBinding


class LightningFragment : Fragment() {

    lateinit var binding: FragmentLightningBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLightningBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton1.drawable.isFilterBitmap = false

        binding.backButton1.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.to_menu2)
        }

        getNewResponse()
    }

    fun getNewResponse() {
        // initialize block | url: REST API site
        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val postService = retrofit.create(PostService::class.java)
        postService.getById(41).enqueue(object: Callback<PostResponse> { // call random post number
            override fun onResponse(
                call: Call<PostResponse>,
                response: Response<PostResponse>
            ) {
                // publish response
                binding.textContainer.text = response.body().toString()
            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                // shitting about response
                Toast.makeText(context,"Error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}