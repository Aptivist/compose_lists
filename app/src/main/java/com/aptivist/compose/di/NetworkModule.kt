package com.aptivist.compose.di

import com.aptivist.compose.data.IAnimalsApi
import com.aptivist.compose.domain.AnimalsApiRepositoryImpl
import com.aptivist.compose.domain.IAnimalsApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideAnimalsApi(retrofit: Retrofit) : IAnimalsApi {
        return retrofit.create(IAnimalsApi::class.java)
    }

    @Singleton
    @Provides
    fun provideAnimalsRepository(iAnimalsApi: IAnimalsApi) : IAnimalsApiRepository {
        return AnimalsApiRepositoryImpl(iAnimalsApi)
    }
}