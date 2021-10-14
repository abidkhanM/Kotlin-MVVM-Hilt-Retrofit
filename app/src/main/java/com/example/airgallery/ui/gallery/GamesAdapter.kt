package com.example.airgallery.ui.gallery

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.airgallery.data.ImageModel
import com.example.airgallery.data.Results
import com.example.airgallery.databinding.ProductsItemBinding

class GamesAdapter(private val listener: ItemListener) : RecyclerView.Adapter<ProductViewHolder>() {

    interface ItemListener {
        fun onClickItem(productId: Int)
    }

    private val items = ArrayList<Results>()

    fun setItems(items: List<Results>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding: ProductsItemBinding = ProductsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) = holder.bind(items[position])
}

class ProductViewHolder(private val itemBinding: ProductsItemBinding, private val listener: GamesAdapter.ItemListener) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var results: Results

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Results) {
        this.results = item
        itemBinding.nameOfGame.text = results.name
        Glide.with(itemBinding.root.context).load(results.backgroundImage).into(itemBinding.image)
    }

    override fun onClick(v: View?) {
        listener.onClickItem(results.id)
    }
}

