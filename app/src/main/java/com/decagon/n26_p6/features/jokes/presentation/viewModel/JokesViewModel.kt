package com.decagon.n26_p6.features.jokes.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decagon.n26_p6.common.utils.Resource
import com.decagon.n26_p6.features.jokes.model.JokesResponseClass
import com.decagon.n26_p6.features.jokes.model.JokesString
import com.decagon.n26_p6.features.jokes.repository.JokesRepositoryRetrofitImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@HiltViewModel
class JokesViewModel (private val repositoryRetrofitImpl: JokesRepositoryRetrofitImpl ) : ViewModel() {

    private val _jokesData = MutableLiveData<Resource<JokesString>>()

    val jokesData : LiveData<Resource<JokesString>> = _jokesData


    fun getJokes() {
        viewModelScope.launch {
            _jokesData.postValue(Resource.Loading("Loading"))
            _jokesData.value = repositoryRetrofitImpl.getAnyJokesAny()
        }
    }

    fun getProgrammingJokes(){
        viewModelScope.launch {
            repositoryRetrofitImpl.getProgrammingJokesData().collect {
                _jokesData.postValue(it)
            }
        }
    }
}