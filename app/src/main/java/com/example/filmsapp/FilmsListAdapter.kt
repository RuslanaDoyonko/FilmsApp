package com.example.filmsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmsapp.databinding.ItemFilmBinding

class FilmsListAdapter(
    private val filmsList: List<Film>
) : RecyclerView.Adapter<FilmsListAdapter.FilmsListViewHolder>() {

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsListViewHolder {
        return FilmsListViewHolder(
            ItemFilmBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            mListener
        )
    }

    override fun onBindViewHolder(holder: FilmsListViewHolder, position: Int) {
        holder.bind(filmsList[position])
    }

    override fun getItemCount(): Int {
        return filmsList.size
    }

    class FilmsListViewHolder(
        private val binding: ItemFilmBinding,
        listener: OnItemClickListener
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                listener.onClick(adapterPosition)
            }
        }

        fun bind(item: Film) = with(binding) {
            tvTitle.text = item.title
            tvDescription.text = item.description
            rbDetailedRate.rating = item.rating
            Glide
                .with(binding.root)
                .load(item.pictureRes)
                .into(icFilm)
        }
    }

}