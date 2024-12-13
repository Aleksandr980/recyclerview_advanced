package com.example.recyclerview_advanced.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview_advanced.R
import com.example.recyclerview_advanced.databinding.CharacterItemBinding

class CharacterPagedListAdapter(
    private val onClick: (com.example.recyclerview_advanced.api.Character) -> Unit
) : PagingDataAdapter<com.example.recyclerview_advanced.api.Character, CharacterViewHolder>(DiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            CharacterItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = getItem(position)
        Log.d("CharacterPagedListAdapter", "CharacterPagedListAdapter ${item}")


        with(holder.binding) {
            name.text = item?.name ?: ""
            lastLocation.text = item?.location?.name ?: ""
            live.text = item?.status ?: ""
            when(item?.status){
                "Alive" ->   statusLive.setImageResource(R.drawable.status_green)
                "Dead" ->   statusLive.setImageResource(R.drawable.status_red)
                else ->   statusLive.setImageResource(R.drawable.status_gray)
            }

            item?.let {
                Glide
                    .with(poster.context)
                    .load(it.image)
                    .into(poster)
            }
        }

        holder.binding.root.setOnClickListener {
            item?.let {
                onClick(item)
            }
        }
    }
}

class DiffUtilCallback : DiffUtil.ItemCallback<com.example.recyclerview_advanced.api.Character>() {

    override fun areItemsTheSame(oldItem: com.example.recyclerview_advanced.api.Character, newItem: com.example.recyclerview_advanced.api.Character): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: com.example.recyclerview_advanced.api.Character, newItem: com.example.recyclerview_advanced.api.Character): Boolean =
        oldItem == newItem
}

class CharacterViewHolder(val binding: CharacterItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

}
