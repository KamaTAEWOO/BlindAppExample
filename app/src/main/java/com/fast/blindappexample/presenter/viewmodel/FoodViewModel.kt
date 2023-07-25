package com.fast.blindappexample.presenter.viewmodel

import androidx.lifecycle.ViewModel
import com.fast.blindappexample.domain.usecase.ContentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(
    private val contentUseCase: ContentUseCase
) : ViewModel() {

}