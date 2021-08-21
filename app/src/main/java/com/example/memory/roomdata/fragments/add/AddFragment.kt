package com.example.memory.roomdata.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.memory.roomdata.R
import com.example.memory.roomdata.data.User
import com.example.memory.roomdata.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mUserViweModel:  UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mUserViweModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.button.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val firstName = firstName_et.text.toString()
        val secondName = secondName_et.text.toString()
        val age = age_et.text

        if (inputCheck(firstName, secondName, age)) {
            //Create User Object
            val user = User(0, firstName, secondName, Integer.parseInt(age.toString()))

            //add data to DataBase

            mUserViweModel.addUser(user)
            Toast.makeText(requireContext(), "Succesfully added", Toast.LENGTH_SHORT).show()

            //Navigate back to Home
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill all Fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName: String, secondName: String, age: Editable): Boolean {
        return  !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(secondName) && age.isEmpty())
    }

}