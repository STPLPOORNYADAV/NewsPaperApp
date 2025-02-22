package com.example.newpaperapp.ui.theme.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newpaperapp.data.model.NewspaperDetail
import com.example.newpaperapp.data.repository.NewspaperRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewspaperDetailViewModel @Inject constructor(
    private val repository: NewspaperRepository
) : ViewModel() {

    private val _newspaperDetail = MutableStateFlow<NewspaperDetail?>(null)
    val newspaperDetail: StateFlow<NewspaperDetail?> = _newspaperDetail

    fun fetchNewspaperDetail(url: String) {
        viewModelScope.launch {
            try {
                _newspaperDetail.value = repository.getNewspaperDetail(url)
            } catch (e: Exception) {
                Log.e("DetailViewModel", "Error fetching data", e)
            }
        }
    }
}
