package com.aptivist.compose.ui.theme

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aptivist.compose.domain.Animal
import com.aptivist.compose.domain.IAnimalsApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val animalsRepository: IAnimalsApiRepository) : ViewModel() {

    private val _animalListState = mutableStateListOf<Animal>()
    val animalListState : SnapshotStateList<Animal>
        get() = _animalListState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val animals = animalsRepository.getAnimalsByQty(10)
            _animalListState.addAll(animals)
        }
    }

}