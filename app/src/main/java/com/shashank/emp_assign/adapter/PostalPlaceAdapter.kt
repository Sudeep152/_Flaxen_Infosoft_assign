package com.shashank.emp_assign.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shashank.emp_assign.R
import com.shashank.emp_assign.data.model.Place
import kotlinx.android.synthetic.main.single_postal.view.*

class PostalPlaceAdapter : RecyclerView.Adapter<PostalPlaceAdapter.PostalViewHolder>() {


    private val differCallBack = object : DiffUtil.ItemCallback<Place>(){
        override fun areItemsTheSame(oldItem: Place, newItem: Place): Boolean {
            return oldItem.place_name == newItem.place_name
        }

        override fun areContentsTheSame(oldItem: Place, newItem: Place): Boolean {
            return oldItem==newItem
        }

    }

    val differ = AsyncListDiffer(this,differCallBack)


    inner  class  PostalViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostalViewHolder {
        return PostalViewHolder( LayoutInflater.from(parent.context).inflate(R.layout.single_postal,parent,false)
        )
    }

    override fun onBindViewHolder(holder: PostalViewHolder, position: Int) {

        val postal =differ.currentList[position]

        holder.itemView.apply {
                 place_edt.text= postal.place_name.toString()
                 state_edt.text= postal.state
            long_at.text=postal.longitude
            lang_at.text=postal.latitude


        }


    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }




}