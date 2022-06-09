package com.mindorks.framework.mvvm.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mindorks.framework.mvvm.R
import com.mindorks.framework.mvvm.data.model.ModelPosts
import kotlinx.android.synthetic.main.item_layout.view.*

class PostsAdatapter (
    private val post: ArrayList<ModelPosts>
) : RecyclerView.Adapter<PostsAdatapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(posts: ModelPosts) {
            itemView.textViewUserName.text = posts.title
            itemView.textViewUserEmail.text = posts.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = post.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(post[position])

    fun addData(list: List<ModelPosts>) {
        post.addAll(list)
    }
}