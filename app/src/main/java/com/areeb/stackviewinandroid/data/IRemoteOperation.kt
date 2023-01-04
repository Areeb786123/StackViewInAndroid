package com.areeb.stackviewinandroid.data

import com.areeb.stackviewinandroid.data.models.home.HeroesDto
import com.areeb.stackviewinandroid.data.models.home.HeroesDtoItem

interface IRemoteOperation {

    suspend fun getHeroes(): Resource<List<HeroesDtoItem>>
}
