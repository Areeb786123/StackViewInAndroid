package com.areeb.stackviewinandroid.di

import com.areeb.stackviewinandroid.data.RemoteDataSource
import com.areeb.stackviewinandroid.data.network.remote.api.home.HomeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {
    @Singleton
    @Provides
    fun providesHomeApi(
        remoteDataSource: RemoteDataSource
    ): HomeApi {
        return remoteDataSource.buildApi(
            HomeApi::class.java,
            "https://www.simplifiedcoding.net/demos/"
        )
    }
}