package com.iliavolkov.popularlibraries.view.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iliavolkov.popularlibraries.R
import com.iliavolkov.popularlibraries.databinding.ItemUserBinding
import com.iliavolkov.popularlibraries.model.GithubUser

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserHolder>() {
    private var userData: List<GithubUser> = listOf()


    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<GithubUser>) {
        this.userData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(userData[position])
    }

    override fun getItemCount() = userData.size

    inner class UserHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item:GithubUser){
            ItemUserBinding.bind(itemView).run {
                tvUserLogin.text = item.login
            }
        }
    }
}