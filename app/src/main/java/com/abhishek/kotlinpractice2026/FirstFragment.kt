package com.abhishek.kotlinpractice2026

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abhishek.kotlinpractice2026.databinding.FragmentFirstBinding

class FirstFragment : Fragment(), Interface {
    lateinit var binding: FragmentFirstBinding

    lateinit var fragmentActivity: FragmentActivity



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentFirstBinding.inflate(layoutInflater)
        fragmentActivity = activity as FragmentActivity
        fragmentActivity.interfaces = this
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding.RButton.setOnClickListener {
            fragmentActivity.setColor()
        }
        return binding.root
    }

    override fun add(value: Int) {
        binding.tview.text = value.toString()
    }

    override fun sub(value: Int) {
        binding.tview.text = value.toString()
    }

    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment FristFragment.
////         */
////        // TODO: Rename and change types and number of parameters
////        @JvmStatic
//////        fun newInstance(param1: String, param2: String) =
//////            FristFragment().apply {
//////                arguments = Bundle().apply {
//////
//////                }
//////            }
    }
}