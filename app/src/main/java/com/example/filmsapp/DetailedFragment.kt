package com.example.filmsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.filmsapp.databinding.FragmentDetailedBinding


class DetailedFragment : Fragment(R.layout.fragment_detailed) {

    private lateinit var binding: FragmentDetailedBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailedBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: DetailedFragmentArgs by navArgs()
        val filmId = args.filmId

        binding.rbDetailedRate.rating = Film.filmsList[filmId].rating
        binding.tvDetailedTitle.text = Film.filmsList[filmId].title
        binding.tvDetailedDescription.text = Film.filmsList[filmId].description
        Glide
            .with(binding.root)
            .load(Film.filmsList[filmId].pictureRes)
            .into(binding.ivDetailedIcon)
    }
}