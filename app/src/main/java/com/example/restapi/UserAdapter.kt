package com.example.restapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi.pojo.User
import kotlinx.android.synthetic.main.users_list_item.view.*

class UserAdapter(var mdataSet: List<User>): RecyclerView.Adapter<UserAdapter.userHolder>() {

    class userHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nameTv= itemView.name
        val emailTv= itemView.email
        val phoneTv= itemView.phone
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userHolder {
        val view: View= LayoutInflater.from(parent.context).inflate(R.layout.users_list_item, parent, false)
        return userHolder(view)
    }

    override fun onBindViewHolder(holder: userHolder, position: Int) {
        val user = mdataSet[position]
        val name ="Name: ${user.name}"
        val email = "Email: ${user.email}"
        val phone = "Phone: ${user.phone}"
        holder.nameTv.text = name
        holder.emailTv.text = email
        holder.phoneTv.text = phone
    }

    override fun getItemCount(): Int {
        return mdataSet.size
    }
}