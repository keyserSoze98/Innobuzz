package com.keysersoze.innobuzz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.keysersoze.innobuzz.databinding.FragmentPostDetailsBinding

class PostDetailsFragment : Fragment() {

    private lateinit var binding: FragmentPostDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postId = arguments?.getInt("postId")
        val postTitle = arguments?.getString("postTitle")
        val postBody = arguments?.getString("postBody")

        binding.postTitleTextView.text = postTitle
        binding.postBodyTextView.text = postBody
    }
}

