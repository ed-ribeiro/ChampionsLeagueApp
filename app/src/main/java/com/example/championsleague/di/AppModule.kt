package com.example.championsleague.di

import com.example.championsleague.common.Constants
import com.example.championsleague.data.remote.FootballDataApi
import com.example.championsleague.data.repository.ChampionsLeagueRepositoryImpl
import com.example.championsleague.domain.repository.ChampionsLeagueRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFootballDataApi(): FootballDataApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FootballDataApi::class.java)
    }

    @Provides
    @Singleton
    fun provideChampionsLeagueRepository(api: FootballDataApi): ChampionsLeagueRepository {
        return ChampionsLeagueRepositoryImpl(api)
    }
}