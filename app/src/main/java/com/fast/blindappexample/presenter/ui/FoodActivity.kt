package com.fast.blindappexample.presenter.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.fast.blindappexample.databinding.ActivityFoodBinding
import com.fast.blindappexample.presenter.viewmodel.FoodViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

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

        Timber.d("FoodActivity onCreate()")
        observeViewModel()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.foodList
                .flowWithLifecycle(lifecycle, Lifecycle.State.RESUMED)
                .collectLatest {
                    Timber.d("FoodActivity observeViewModel() collectLatest()")
                }
        }
    }

    companion object {

        fun start(context: Context) {
            Intent(context, FoodActivity::class.java).apply {
                context.startActivity(this)
            }
        }
    }
}