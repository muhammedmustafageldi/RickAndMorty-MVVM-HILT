package com.swanky.rickandmortymvvm.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.swanky.rickandmortymvvm.R

fun ImageView.downloadUrl(url: String, progressDrawable: CircularProgressDrawable){
    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.drawable.icon)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}

fun View.hide(){
    this.visibility = View.GONE
}

fun View.show(){
    this.visibility = View.VISIBLE
}


fun placeHolderProgressBar(context: android.content.Context) : CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}


@BindingAdapter("app:downloadUrl")
fun downloadImage(imageView: ImageView, url: String?) {
    url?.let {
        imageView.downloadUrl(url, placeHolderProgressBar(imageView.context))
    } ?: run {
        imageView.setImageResource(R.drawable.icon)
    }

}

@BindingAdapter("app:setStatusIcon")
fun setStatusIcon(imageView: ImageView, status: String?) {
    when (status) {
        "Alive" -> imageView.setImageResource(R.drawable.alive)
        "Dead" -> imageView.setImageResource(R.drawable.dead)
        else -> imageView.setImageResource(R.drawable.unknown)
    }
}
