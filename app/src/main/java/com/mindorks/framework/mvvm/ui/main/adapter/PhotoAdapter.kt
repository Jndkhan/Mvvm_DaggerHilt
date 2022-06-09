package com.mindorks.framework.mvvm.ui.main.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mindorks.framework.mvvm.R
import com.mindorks.framework.mvvm.data.model.ModelPhotos
import kotlinx.android.synthetic.main.item_photo.view.*

class PhotoAdapter(
    private val modelphotos: ArrayList<ModelPhotos>
) : RecyclerView.Adapter<PhotoAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(modelPhotos: ModelPhotos) {
            Log.e("Photo_TAG", "bind:"+modelPhotos.thumbnailUrl)
            itemView.txtTitle.text = modelPhotos.title
            Glide.with(itemView.imgProfile.context)
                .load(modelPhotos.thumbnailUrl+".jpg")
                .into(itemView.imgProfile)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_photo, parent,
                false
            )
        )

    override fun getItemCount(): Int = modelphotos.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(modelphotos[position])

    fun addData(list: List<ModelPhotos>) {
        modelphotos.addAll(list)
    }
}