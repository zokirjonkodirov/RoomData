package com.example.memory.roomdata.fragments.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.memory.roomdata.R
import com.example.memory.roomdata.data.User
import kotlinx.android.synthetic.main.custom_raw.view.*

/**
 * @author user
 * @date 21.08.2021
 */
class ListAapter(): RecyclerView.Adapter<ListAapter.ItemHolder>() {

    private var userList: List<User> = emptyList<User>()

    inner class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return (ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_raw, parent, false)))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.order_txt.text = currentItem.id.toString()
        holder.itemView.firstName_txt.text = currentItem.firstName
        holder.itemView.secondName_txt.text = currentItem.lastName
        holder.itemView.age_txt.text = currentItem.age.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }
}