package com.example.mvvm.ui.gamedetail

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.mvvm.databinding.FragmentGameDetailsBinding
import com.example.mvvm.utils.Resource
import com.example.mvvm.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment : Fragment(){

    private var binding: FragmentGameDetailsBinding by autoCleared()
    private val viewModel: GameDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "..."
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentGameDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.gameDetails.observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    it.data?.let { list ->
                        binding.gameName.text = list.name
                        binding.released.text = list.released
                        binding.description.text = Html.fromHtml(list.description)
                        binding.userProvidedRating.rating = list.rating.toFloat()
                        Glide.with(requireActivity()).load(list.backgroundImage).into(binding.image)
                        binding.mainLayout.visibility = VISIBLE
                        (requireActivity() as AppCompatActivity).supportActionBar?.title = list.name
                    }
                    binding.progressBar.visibility = View.GONE
                }
                Resource.Status.ERROR -> Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
            }
        })
    }
}
