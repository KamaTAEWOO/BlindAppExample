package com.fast.blindappexample.presenter.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.fast.blindappexample.databinding.ActivityFoodBinding
import com.fast.blindappexample.presenter.viewmodel.FoodViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFoodBinding
    private val viewModel: FoodViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFoodBinding.inflate(layoutInflater).apply {
            setContentView(root)
            lifecycleOwner = this@FoodActivity
            viewModel = this@FoodActivity.viewModel
        }

        viewModel.initLoadList()
    }

    companion object {

        fun start(context: Context) {
            Intent(context, FoodActivity::class.java).apply {
                context.startActivity(this)
            }
        }
    }
}