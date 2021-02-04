package com.androidbala.koinsample.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidbala.koinsample.databinding.ActivityHomeBinding
import com.androidbala.koinsample.ui.album.AlbumActivity
import com.androidbala.koinsample.ui.user.UserListActivity
import com.androidbala.koinsample.utils.viewBinding

class HomeScreen: AppCompatActivity() {

    val binding by viewBinding (ActivityHomeBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.tvAlbum.setOnClickListener {
            startActivity(Intent(this@HomeScreen, AlbumActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            })
        }

        binding.tvUsers.setOnClickListener {
            startActivity(Intent(this@HomeScreen, UserListActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            })
        }

    }

}