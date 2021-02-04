package com.androidbala.koinsample.ui.album

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidbala.koinsample.User
import com.androidbala.koinsample.data.model.Albums
import com.androidbala.koinsample.databinding.ItemAlbumBinding
import com.androidbala.koinsample.databinding.ItemUserBinding
import com.androidbala.koinsample.ui.user.adapter.UserAdapter

class AlbumAdapter(private val albums: ArrayList<Albums>) : RecyclerView.Adapter<AlbumAdapter.DataViewHolder>() {

    class DataViewHolder(private val binding: ItemAlbumBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(album: Albums) {
            Log.d("ehedood", "ohogpfdpdpdpfp ${album.title}")
            binding.textViewAlbumName.text = album.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        ItemAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = albums.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) = holder.bind(albums[position])

    fun addData(list: List<Albums>) {
        albums.addAll(list)
    }

}