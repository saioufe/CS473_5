package com.example.cs473_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_item_clicked.*

class ItemClicked : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_clicked)

        var intent = intent

        txt_item_clicked.text = intent.getStringExtra("description")
        img_item_clicked.setImageResource(intent.getIntExtra("image" , R.drawable.sugar_cubes))
    }
}