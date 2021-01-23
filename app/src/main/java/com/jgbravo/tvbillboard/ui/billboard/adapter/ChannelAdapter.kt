package com.jgbravo.tvbillboard.ui.billboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.jgbravo.tvbillboard.data.entities.Channel
import com.jgbravo.tvbillboard.databinding.CardviewChannelBinding
import com.jgbravo.tvbillboard.utils.Constants.BASE_URL_IMAGES

class ChannelAdapter : RecyclerView.Adapter<ChannelAdapter.ChannelViewHolder>() {

    inner class ChannelViewHolder(val binding: CardviewChannelBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Channel>() {
        override fun areItemsTheSame(oldItem: Channel, newItem: Channel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Channel, newItem: Channel): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    private var onItemClickListener: ((Channel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
        val binding = CardviewChannelBinding.inflate(LayoutInflater.from(parent.context))
        return ChannelViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        val channel = getItem(position)

        holder.binding.apply {
            setOnClickListener {
                onItemClickListener?.let {
                    it(channel)
                }
            }

            channelName.text = channel.name

            Glide.with(holder.binding.root)
                .load("$BASE_URL_IMAGES${channel.imageEndpoint}")
                .fitCenter()
                .apply(RequestOptions.bitmapTransform(RoundedCorners(10)))
                .into(channelImage)

        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun getItem(position: Int): Channel = differ.currentList[position]

    fun submitList(list: List<Channel>) {
        differ.submitList(list)
    }

    fun setOnClickListener(listener: (Channel) -> Unit) {
        onItemClickListener = listener
    }
}