package com.androidbala.koinsample.ui.user.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.androidbala.koinsample.User
import com.androidbala.koinsample.databinding.ItemUserBinding
import com.bumptech.glide.Glide

class UserAdapter(private val users: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.DataViewHolder>() {

    class DataViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.textViewUserName.text = user.name
            binding.textViewUserEmail.text = user.address?.city
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) = holder.bind(users[position])

    fun addData(list: List<User>) {
        users.addAll(list)
    }

}