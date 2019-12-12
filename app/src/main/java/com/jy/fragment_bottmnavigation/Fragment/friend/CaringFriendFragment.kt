package com.jy.fragment_bottmnavigation.Fragment.friend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jy.fragment_bottmnavigation.R

class CaringFriendFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_friend, container, false)
        val friendList = mutableListOf<String>()
        for(i in 0..100){
            friendList.add("May No.$i")
        }
        val friendAdapter = FriendListAdapter(friendList)
        val lm = LinearLayoutManager(this.context)
        view.findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = lm
            adapter = friendAdapter
        }
        return view
    }
}