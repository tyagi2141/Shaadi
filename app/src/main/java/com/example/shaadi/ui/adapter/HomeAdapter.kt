package com.example.shaadi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.shaadi.R
import com.example.shaadi.common.CommonConstant
import com.example.shaadi.databinding.HomeItemBinding
import com.example.shaadi.model.Results


class HomeAdapter(var eventsList: List<Results>, private val onTabCallback: OnTabCallback) :
    RecyclerView.Adapter<HomeAdapter.viewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemBinding =
            HomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val events: Results = eventsList[position]
        holder.bind(events, onTabCallback)
    }

    override fun getItemCount(): Int = eventsList.size

    class viewHolder(private val itemBinding: HomeItemBinding, val context: Context) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(result: Results, onTabCallback: OnTabCallback) {
            Glide.with(context)
                .load(result.picture?.large)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.ic_broken_image)
                .into(itemBinding.imgUserId)

            itemBinding.tvUserNameId.text =
                " ${result.name?.title} ${result.name?.first} ${result.name?.last}"
            itemBinding.tvUserDetailsId.text =
                "${result.dob?.age} , ${result.location?.city} , ${result.location?.country}"

            if (result.statusFlag == CommonConstant.REJECT) {
                itemBinding.btnDeclineId.background =
                    context.getDrawable(R.drawable.ic_disable_cancel)
                itemBinding.btnAcceptId.background =
                    context.getDrawable(R.drawable.ic_baseline_check_circle_24)
            } else if (result.statusFlag == CommonConstant.APPROVED) {
                itemBinding.btnDeclineId.background =
                    context.getDrawable(R.drawable.ic_baseline_cancel_24)
                itemBinding.btnAcceptId.background =
                    context.getDrawable(R.drawable.ic_disable_check_circle)
            } else {
                itemBinding.btnDeclineId.background =
                    context.getDrawable(R.drawable.ic_baseline_cancel_24)
                itemBinding.btnAcceptId.background =
                    context.getDrawable(R.drawable.ic_baseline_check_circle_24)
            }


            itemBinding.btnDeclineId.setOnClickListener {
                onTabCallback.onSelected(result, CommonConstant.REJECT)
            }

            itemBinding.btnAcceptId.setOnClickListener {
                onTabCallback.onSelected(result, CommonConstant.APPROVED)
            }
        }
    }

    interface OnTabCallback {
        fun onSelected(results: Results?, statusType: Int)
    }
}