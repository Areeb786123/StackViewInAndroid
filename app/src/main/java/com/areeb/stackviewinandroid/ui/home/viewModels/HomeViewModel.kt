package com.areeb.stackviewinandroid.ui.home.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.areeb.stackviewinandroid.data.Resource
import com.areeb.stackviewinandroid.data.models.home.HeroesDto
import com.areeb.stackviewinandroid.data.models.home.HeroesDtoItem
import com.areeb.stackviewinandroid.data.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    companion object {
        private const val TAG = "HomeViewModel"
    }

    init {
        getHeroes()
    }

    private val _heroes = MutableLiveData<List<HeroesDtoItem>>()
    val heroes: LiveData<List<HeroesDtoItem>>
        get() = _heroes

    init {
        getHeroes()
    }

   private  fun getHeroes() {
        viewModelScope.launch {
            repository.getHeroes()
                .catch { exception ->
                    Log.e(TAG, exception.toString())
                }.collect {
                    setHeroesResponse(it)
                }
        }
    }

    private fun setHeroesResponse(response: Resource<List<HeroesDtoItem>>) {
        if (response is Resource.Success) {
            response.data.let {
                _heroes.value = it
                Log.e("testData", it.toString())
            }
        }
    }
}
