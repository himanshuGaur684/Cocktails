package com.gaur.cocktails.di

import com.gaur.cocktails.common.Constants
import com.gaur.cocktails.data.remote.CocktailApi
import com.gaur.cocktails.data.repository.DrinkRepository_Impl
import com.gaur.cocktails.domain.repository.DrinkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CocktailModules {


    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL).build()
    }


    @Provides
    fun provideCocktailAPI(retrofit: Retrofit): CocktailApi {
        return retrofit.create(CocktailApi::class.java)
    }


    @Provides
    fun provideDrinkRepository(api: CocktailApi): DrinkRepository {
        return DrinkRepository_Impl(api)
    }

}