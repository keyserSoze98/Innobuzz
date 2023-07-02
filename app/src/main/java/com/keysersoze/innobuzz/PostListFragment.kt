package com.keysersoze.innobuzz

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.keysersoze.innobuzz.databinding.FragmentPostListBinding

class PostListFragment : Fragment() {

    private lateinit var binding: FragmentPostListBinding
    private lateinit var postAdapter: PostAdapter
    private val viewModel: PostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostListBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postAdapter = PostAdapter(emptyList()) { post ->
            val action = PostListFragmentDirections.showPostDetails(post.id, post.title, post.body)
            findNavController().navigate(action)
        }

        binding.postRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = postAdapter

            addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        }

        viewModel.posts.observe(viewLifecycleOwner) { posts ->
            postAdapter.posts = posts
            postAdapter.notifyDataSetChanged()
        }

        viewModel.fetchPosts()
    }
}
