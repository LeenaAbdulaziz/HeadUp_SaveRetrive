package com.example.headup_saveretrive

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*


//import kotlinx.android.synthetic.main.single_item.view.*

class RecycleView(val activity: AddCelebrity, val celebries: ArrayList<Celebrity>) : RecyclerView.Adapter<RecycleView.recyclerViewHolder>() {
    class recyclerViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recyclerViewHolder {
        return recyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item,
                parent,
                false))
    }

    override fun onBindViewHolder(holder: recyclerViewHolder, position: Int) {
        val celb = celebries[position]

        holder.itemView.apply {

            textview2.text = " ${celb.name} \n ${celb.taboo1}\n" +
                    "${celb.taboo2}\n${celb.taboo3} "

            imageView.setOnClickListener {
                activity.Updatecelb(celb)
            }
            imageView2.setOnClickListener {
                activity.confirm(celb)
            }
        }}


    override fun getItemCount()=celebries.size
}