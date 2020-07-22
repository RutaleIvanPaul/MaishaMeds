package com.example.maishameds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maishameds.service.RequestManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val requestManager =
        RequestManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postsRecyclerView.layoutManager = LinearLayoutManager(this)
        requestManager.returnPostsFromApi(postsRecyclerView,this)
    }
}