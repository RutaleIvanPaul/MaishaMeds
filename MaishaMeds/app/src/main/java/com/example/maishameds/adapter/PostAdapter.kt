package com.example.maishameds.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maishameds.R
import com.example.maishameds.models.PostsItem
import kotlinx.android.synthetic.main.postitem.view.*

class PostAdapter(val context: Context, val posts: List<PostsItem>): RecyclerView.Adapter<PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder(
            LayoutInflater.from(
                context
            ).inflate(
                R.layout.postitem,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.id.text = "ID: " + posts[position].id.toString()
        holder.userId.text = "User ID: " + posts[position].userId.toString()
        holder.title.text = posts[position].title
        holder.body.text = posts[position].body
    }

}

class PostsViewHolder(view: View): RecyclerView.ViewHolder(view){
    val id = view.id_textView
    val userId = view.user_id_textView
    val title = view.title_textView
    val body = view.body_textView
}

