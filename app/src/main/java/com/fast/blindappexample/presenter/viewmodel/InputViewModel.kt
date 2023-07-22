package com.fast.blindappexample.presenter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fast.blindappexample.domain.model.Content
import com.fast.blindappexample.domain.usecase.ContentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InputViewModel @Inject constructor(
    private val contentUseCase: ContentUseCase
) : ViewModel() {

    private val _doneEvent = MutableLiveData<Pair<Boolean, String>>()
    val doneEvent = _doneEvent

    var category = MutableLiveData("")
    var title = MutableLiveData("")
    var content = MutableLiveData("")
    private var item : Content? = null


    fun initData(item: Content) {
        this.item = item
        category.value = item.category
        title.value = item.title
        content.value = item.content
    }

    fun insertData() {
        val categoryValue = category.value
        val titleValue = title.value
        val contentValue = content.value

        if(categoryValue.isNullOrBlank() || titleValue.isNullOrBlank() || contentValue.isNullOrBlank()) {
            _doneEvent.value = Pair(false, "빈칸을 모두 채워주세요.")
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            contentUseCase.save(
                item?.copy(
                    category = categoryValue,
                    title = titleValue,
                    content = contentValue
                ) ?: Content(
                    category = categoryValue,
                    title = titleValue,
                    content = contentValue
                ).also {
                    _doneEvent.postValue(
                        Pair(true, if(it as Boolean) "저장되었습니다." else "저장에 실패했습니다.")
                    )
                }
            )
        }
    }
}