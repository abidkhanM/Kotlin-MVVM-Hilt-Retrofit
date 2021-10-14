package com.example.airgallery.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.airgallery.R
import com.example.airgallery.databinding.FragmentSearchImageBinding
import com.example.airgallery.utils.Resource
import com.example.airgallery.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment : Fragment(), GamesAdapter.ItemListener {

    private var binding: FragmentSearchImageBinding by autoCleared()
    private val viewModel: GameViewModel by viewModels()
    private lateinit var adapter: GamesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSearchImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        adapter = GamesAdapter(this)
        binding.rvListOfGames.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvListOfGames.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.gamesList.observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    it.data?.let { list ->
                        adapter.setItems(list.results)
                    }
                    binding.progressBar.visibility = View.GONE
                }
                Resource.Status.ERROR -> Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    override fun onClickItem(gameId: Int) {
        val bundle = bundleOf("gameId" to gameId as Int)
        findNavController().navigate(R.id.actionGameToGameDetail, bundle)
    }
}
