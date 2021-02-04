package com.androidbala.koinsample.ui.album

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidbala.koinsample.R
import com.androidbala.koinsample.User
import com.androidbala.koinsample.data.model.Albums
import com.androidbala.koinsample.databinding.ActivityAlbumBinding
import com.androidbala.koinsample.databinding.ActivityMainBinding
import com.androidbala.koinsample.ui.user.adapter.UserAdapter
import com.androidbala.koinsample.ui.user.viewmodel.UserViewModel
import com.androidbala.koinsample.utils.Status
import com.androidbala.koinsample.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AlbumActivity: AppCompatActivity() {

    private val binding by viewBinding(ActivityAlbumBinding::inflate)
    private val albumViewModel : AlbumViewModel by viewModel()
    private lateinit var adapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupUI()
        setupObserver()

    }

    private fun setupUI() {

        binding.recyclerViewAlbum.layoutManager = LinearLayoutManager(this)
        adapter = AlbumAdapter(arrayListOf())

        binding.recyclerViewAlbum.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerViewAlbum.context,
                (binding.recyclerViewAlbum.layoutManager as LinearLayoutManager).orientation
            )
        )

        binding.recyclerViewAlbum.adapter = adapter

    }

    private fun setupObserver() {
        albumViewModel.albums.observe(this, Observer {
            when (it.status) {

                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { albums -> renderList(albums) }
                    binding.recyclerViewAlbum.visibility = View.VISIBLE
                }

                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerViewAlbum.visibility = View.GONE
                }

                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(albums: List<Albums>) {
        adapter.addData(albums)
        adapter.notifyDataSetChanged()
    }


}