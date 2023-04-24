package com.example.filmsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmsapp.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var filmsListAdapter: FilmsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(layoutInflater)
        filmsListAdapter = FilmsListAdapter(Film.filmsList)
        binding.rvFilmsList.layoutManager = LinearLayoutManager(context)
        binding.rvFilmsList.adapter = filmsListAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filmsListAdapter.setOnItemClickListener(object : FilmsListAdapter.OnItemClickListener {
            override fun onClick(position: Int) {
                view.findNavController().navigate(
                    ListFragmentDirections.actionListFragmentToDetailedFragment(position)
                )
            }
        })
    }
}