package com.fast.blindappexample.presenter.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fast.blindappexample.databinding.ActivityFoodfindBinding

class FoodFindActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFoodfindBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFoodfindBinding.inflate(layoutInflater).apply {
            setContentView(root)
            view = this@FoodFindActivity
        }
    }

    companion object {

        fun start(context: Context) {
            Intent(context, FoodFindActivity::class.java)
        }
    }
}