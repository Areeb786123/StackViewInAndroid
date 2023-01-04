package com.areeb.stackviewinandroid.data.repository

import com.areeb.stackviewinandroid.data.RemoteOperations
import com.areeb.stackviewinandroid.data.Resource
import com.areeb.stackviewinandroid.data.models.home.HeroesDto
import com.areeb.stackviewinandroid.data.models.home.HeroesDtoItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val remoteOperations: RemoteOperations
) {
    fun getHeroes(): Flow<Resource<List<HeroesDtoItem>>> {
        return flow {
            val heroesResponse = remoteOperations.getHeroes()
            emit(heroesResponse)
        }.flowOn(Dispatchers.IO)
    }
}
