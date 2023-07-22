package com.fast.blindappexample.presenter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fast.blindappexample.domain.model.Content
import dagger.hilt.android.lifecycle.HiltViewModel

//@HiltViewModel
class InputViewModel : ViewModel() {

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

        // api 호출
    }
}