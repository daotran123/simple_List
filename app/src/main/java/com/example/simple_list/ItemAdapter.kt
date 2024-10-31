package com.example.simple_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(val items: List<ItemModel>):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView : TextView
        init{
            textView = itemView.findViewById(R.id.text_view)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
//    Log.v("TAG", "onCreateViewHolder")
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        val item = items[position]
        holder.textView.text = item.value.toString()
    }

    override fun getItemCount(): Int{
        return items.size
    }
}