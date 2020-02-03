package com.jy.fragment_bottmnavigation.Fragment.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.jy.fragment_bottmnavigation.R

class HomeFragment: Fragment() {

    private val TAG = this::class.java.simpleName
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val chipGroup = view.findViewById<ChipGroup>(R.id.chip_group)
        chipGroup.setOnCheckedChangeListener(object: ChipGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: ChipGroup?, checkedId: Int) {
                Log.d(TAG, group?.findViewById<Chip>(checkedId)?.text.toString())
            }

        })
    }
}