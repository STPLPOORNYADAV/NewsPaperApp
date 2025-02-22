package com.example.newpaperapp.ui.theme.viewmodel

import androidx.lifecycle.ViewModel
import com.example.newpaperapp.data.model.NewspaperItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.example.newpaperapp.data.repository.NewspaperRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class NewspaperListViewModel @Inject constructor(private val repository: NewspaperRepository) : ViewModel() {

    private val _newspapers = MutableStateFlow<List<NewspaperItem>>(emptyList()) // StateFlow
    val newspapers: StateFlow<List<NewspaperItem>> = _newspapers

    init {
        viewModelScope.launch {
            _newspapers.value = repository.getNewspapers()
        }
    }
}