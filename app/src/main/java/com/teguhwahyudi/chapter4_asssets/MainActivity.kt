package com.teguhwahyudi.chapter4_asssets

import android.content.Context
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import java.io.IOException

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.ivRocket)
        val fileName = "rocket.png"
        imageView.setImageAssets(applicationContext,fileName)
    }
}

fun ImageView.setImageAssets(context: Context, fileName: String){
    try {
        with(context.assets.open(fileName)){
            setImageBitmap(BitmapFactory.decodeStream(this))
        }
    }catch (e: IOException) {
        Log.e(TAG, e.toString())
    }
}