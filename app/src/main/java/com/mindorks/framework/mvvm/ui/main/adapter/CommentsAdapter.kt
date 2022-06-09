package com.mindorks.framework.mvvm.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mindorks.framework.mvvm.R
import com.mindorks.framework.mvvm.data.model.ModelComments
import kotlinx.android.synthetic.main.item_comments.view.*

class CommentsAdapter(private val comments: ArrayList<ModelComments>) :
    RecyclerView.Adapter<CommentsAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(comments: ModelComments) {
            itemView.txtId.text = comments.id.toString()
            itemView.txtEmail.text = comments.email
            itemView.txtBody.text = comments.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_comments, parent, false)
    )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(comments[position])
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    fun addComments(list: List<ModelComments>) {
        comments.addAll(list)
    }

}