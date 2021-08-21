package com.mondiamedia.ahmedbadr.sarytask.ui.adapters

import CatalogItemData
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mondiamedia.ahmedbadr.sarytask.databinding.CatalogItemBinding


class CatalogAdapter(
    private val catalogItems: List<CatalogItemData>,
    private val dataType: String,
    private val rowCount: Int
) : RecyclerView.Adapter<CatalogAdapter.CatalogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val binding = CatalogItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatalogViewHolder(binding)
    }

    private fun dpToPx(dp: Int): Int {
        return (dp * Resources.getSystem().displayMetrics.density).toInt()
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        val catalogItem = catalogItems[position]

        when (holder.itemViewType) {
            0 -> {
                holder.binding.itemPhoto.layoutParams.width = dpToPx(40)
                holder.binding.itemPhoto.layoutParams.height = dpToPx(40)
            }
            1 -> {
                holder.binding.itemPhoto.layoutParams.width = dpToPx(80)
                holder.binding.itemPhoto.layoutParams.height = dpToPx(80)
            }
            else -> {
                if (rowCount == 2) {
                    holder.binding.itemPhoto.layoutParams.width = dpToPx(200)
                    holder.binding.itemPhoto.layoutParams.height = dpToPx(100)
                } else {
                    holder.binding.itemPhoto.layoutParams.width = dpToPx(80)
                    holder.binding.itemPhoto.layoutParams.height = dpToPx(80)
                }
            }
        }

        holder.binding.itemName.text = catalogItem.name
        holder.binding.itemPhoto.load(catalogItem.image) {
            crossfade(true)
        }
    }

    override fun getItemCount(): Int {
        return catalogItems.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (dataType) {
            "smart" -> {
                0
            }
            "group" -> {
                1
            }
            else -> {
                2
            }
        }
    }

    inner class CatalogViewHolder(val binding: CatalogItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}