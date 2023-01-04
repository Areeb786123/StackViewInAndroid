package com.areeb.stackviewinandroid.data

import com.areeb.stackviewinandroid.data.models.home.HeroesDto
import com.areeb.stackviewinandroid.data.models.home.HeroesDtoItem
import com.areeb.stackviewinandroid.data.network.remote.api.home.HomeApi
import javax.inject.Inject

class RemoteOperations @Inject constructor(
    private val homeApi: HomeApi
) : IRemoteOperation, SafeApiCall {
    override suspend fun getHeroes(): Resource<List<HeroesDtoItem>> {
        return safeApiCall { homeApi.getHeroes() }
    }
}
