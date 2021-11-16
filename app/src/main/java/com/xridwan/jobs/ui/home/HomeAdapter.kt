package com.xridwan.jobs.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xridwan.jobs.databinding.ViewItemStoreBinding
import com.xridwan.jobs.room.Entity

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var storeList = arrayListOf<Entity>()

    fun setData(storeList: ArrayList<Entity>) {
        this.storeList = storeList
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ViewItemStoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Entity) {
            with(binding) {
                tvName.text = data.store_name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ViewItemStoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(storeList[position])
    }

    override fun getItemCount(): Int = storeList.size
}