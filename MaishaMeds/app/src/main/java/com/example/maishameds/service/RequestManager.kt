package com.example.maishameds.service

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.maishameds.adapter.PostAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RequestManager {
    private var disposable: Disposable? = null

    private val apiServe by lazy {
        ApiService.create()
    }

    fun returnPostsFromApi(recyclerView: RecyclerView,context: Context) {
        disposable = apiServe.returnPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    val posts = result
                    recyclerView.adapter = PostAdapter(posts = posts,
                        context = context)

                },
                { error ->
                    Log.d("API ERROR", "API Fetch Error: ${error.message} ")
                }
            )
    }
}