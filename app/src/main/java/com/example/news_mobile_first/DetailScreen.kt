package com.example.news_mobile_first

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.news_mobile_first.databinding.ActivityDetailScreenBinding
import com.squareup.picasso.Picasso

class DetailScreen : AppCompatActivity() {

    private lateinit var binding : ActivityDetailScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_screen)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_detail_screen)

        val url = intent.getStringExtra("url")
        val imageurl = intent.getStringExtra("imageurl")
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val content = intent.getStringExtra("content")
        val author = intent.getStringExtra("author")
        val time = intent.getStringExtra("time")

        binding.authorname.text = author
        binding.time.text = time
        binding.newsHeadline.text = title
        binding.newsDescription.text = description
        binding.newsContent.text = content

        if(imageurl!=null) {
            Picasso.get().load(imageurl).into(binding.imageView)
        }
        binding.viewbrowser.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            // Verify that the intent can be resolved to avoid crashes
            if (intent.resolveActivity(packageManager) != null) {
                // Start the activity to open the URL in a web browser
                startActivity(intent)
            }
        }

    }
}