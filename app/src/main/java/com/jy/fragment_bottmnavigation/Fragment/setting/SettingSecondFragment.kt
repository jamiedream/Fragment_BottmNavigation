package com.jy.fragment_bottmnavigation.Fragment.setting

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jy.fragment_bottmnavigation.R

class SettingSecondFragment: Fragment(){

    private val TAG = this::class.java.simpleName
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        requireActivity().onBackPressedDispatcher.addCallback(
//            this,
//            object : OnBackPressedCallback(true) {
//                override fun handleOnBackPressed() {
//                    Log.d(TAG, "handleOnBackPressed")
//                    findNavController().navigate(R.id.action_navigation_setting_second_to_navigation_setting)
//                }
//
//            }
//        )
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_setting_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.findViewById<Button>(R.id.btn_previous).setOnClickListener {
            findNavController().navigate(R.id.action_navigation_setting_second_to_navigation_setting)
        }

    }


}