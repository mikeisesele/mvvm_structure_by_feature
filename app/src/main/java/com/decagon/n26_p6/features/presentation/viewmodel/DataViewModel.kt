package com.decagon.n26_p6.features.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decagon.n26_p6.common.utils.Resource
import com.decagon.n26_p6.features.model.data.DataSafe
import com.decagon.n26_p6.features.usecase.contracts.IGetDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(private val useCase: IGetDataUseCase) : ViewModel(){

    private val _data = MutableLiveData<Resource<DataSafe>>()
    val data : LiveData<Resource<DataSafe>> = _data


    fun getData() {
        viewModelScope.launch {
            useCase.invoke().collect {
                _data.postValue(it)
            }
        }
    }

}