package com.example.shaadimatchlist.adapters

import android.graphics.Color
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.shaadimatchlist.R
import com.example.shaadimatchlist.extensions.*
import com.example.shaadimatchlist.models.User
import com.example.shaadimatchlist.room.UserInfo
import java.io.File
import java.util.*

class UserRecyclerAdapter(val mOnButtonClickListener: OnButtonClickListener) : RecyclerView.Adapter<UserViewHolder>(){
    private var mUsers: List<UserInfo> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.match_list_item, parent, false)
        return UserViewHolder(view, mOnButtonClickListener)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.userName.text = mUsers[position].formattedName()
        holder.location.text = mUsers[position].agePlusLocation()
        holder.country.text = mUsers[position].country
        holder.userId = mUsers[position].uuid
        holder.acceptButton.setTextForAcceptButton(mUsers[position].isAccepted)
        holder.declineButton.setTextForDeclineButton(mUsers[position].isDeclined)
        holder.acceptButton.setColorForAcceptButton(mUsers[position].isAccepted)
        holder.declineButton.setColorForDeclineButton(mUsers[position].isDeclined)
        val requestOptions: RequestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)

        Glide.with(holder.itemView.context)
                .setDefaultRequestOptions(requestOptions)
                .load(mUsers[position].imageUrl)
                .into(holder.userImageView)
    }

    override fun getItemCount(): Int {
        return mUsers.size
    }

    fun setUsers(users: List<UserInfo>) {
        mUsers = users
        notifyDataSetChanged()
    }
}