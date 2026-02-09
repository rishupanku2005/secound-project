package com.abhishek.kotlinpractice2026

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.abhishek.kotlinpractice2026.databinding.ActivityListViewBinding
import com.abhishek.kotlinpractice2026.databinding.FragmentListBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding


    lateinit var arrayAdapterView: ArrayAdapter<String>
    var studentList = arrayListOf("Mukesh","Abhi","Abhishek","Rishu")
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentListBinding.inflate(layoutInflater)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arrayAdapterView = ArrayAdapter(requireActivity(),android.R.layout.simple_list_item_1 ,studentList)
        binding.lv.adapter = arrayAdapterView

        binding.floatbtn.setOnClickListener {
            studentList.add("Ram")
            arrayAdapterView.notifyDataSetChanged()
            binding.lv.isEnabled = true
            print(studentList)
        }
        binding.lv.onItemClickListener =
            AdapterView.OnItemClickListener{parent, view, position, id ->
                studentList.set(4,"Mohit")
                arrayAdapterView.notifyDataSetChanged()
                print(studentList)
            }

        binding.lv.onItemLongClickListener =
            AdapterView.OnItemLongClickListener{parent, view, position, id ->
                studentList.removeAt(4)
                arrayAdapterView.notifyDataSetChanged()
                print(studentList)
                return@OnItemLongClickListener true
            }
        return binding.root
    }

    companion object {

            }
    }
