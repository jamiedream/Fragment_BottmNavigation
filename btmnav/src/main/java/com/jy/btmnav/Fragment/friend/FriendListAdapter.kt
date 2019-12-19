package com.jy.fragment_bottmnavigation.Fragment.friend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jy.btmnav.R

class FriendListAdapter(private val nameList: MutableList<String>): RecyclerView.Adapter<FriendListAdapter.FriendListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendListHolder {
        return FriendListHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_list_friend, parent, false))
    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    override fun onBindViewHolder(holder: FriendListHolder, position: Int) {
        holder.name.text = nameList[position]
    }

    class FriendListHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name: TextView by lazy { itemView.findViewById<TextView>(R.id.name) }
    }
}