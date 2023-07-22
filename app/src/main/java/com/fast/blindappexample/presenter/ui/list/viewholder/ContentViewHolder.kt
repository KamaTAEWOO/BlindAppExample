package com.fast.blindappexample.presenter.ui.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.fast.blindappexample.databinding.ItemContentBinding
import com.fast.blindappexample.domain.model.Content
import com.fast.blindappexample.presenter.ui.MainActivity

class ContentViewHolder(
    private val binding: ItemContentBinding,
    private val handler: MainActivity.Handler
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Content) {
        binding.item = item
        binding.handler = handler
    }
}