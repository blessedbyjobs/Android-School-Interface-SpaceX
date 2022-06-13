package com.example.android_school_spacex.di

import com.example.android_school_spacex.network.SpaceXApi
import com.example.android_school_spacex.network.SpaceXInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class SpaceXModule {

    @Provides
    fun provideSpaceXApi(retrofit: Retrofit): SpaceXApi = retrofit.create(SpaceXApi::class.java)

    @Provides
    fun provideSpaceXInteractor(spaceXApi: SpaceXApi) = SpaceXInteractor(spaceXApi)
}