package com.areeb.stackviewinandroid.data.network.remote.api.home

import com.areeb.stackviewinandroid.data.models.home.HeroesDto
import com.areeb.stackviewinandroid.data.models.home.HeroesDtoItem
import retrofit2.http.GET

interface HomeApi {
    @GET("marvel")
    suspend fun getHeroes(): List<HeroesDtoItem>
}