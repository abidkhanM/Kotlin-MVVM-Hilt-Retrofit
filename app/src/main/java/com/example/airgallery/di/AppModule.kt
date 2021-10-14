package com.example.airgallery.di


import com.example.airgallery.datasources.GameRemoteDataSource
import com.example.airgallery.network.GameAPIsService
import com.example.airgallery.repository.GameRepository
import com.example.airgallery.utils.Constants.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideProductsService(retrofit: Retrofit): GameAPIsService = retrofit.create(
        GameAPIsService::class.java)

    @Singleton
    @Provides
    fun provideProductsRemoteResponse(_Game_APIsService: GameAPIsService) = GameRemoteDataSource(_Game_APIsService)


    @Singleton
    @Provides
    fun provideProductsRepository(gameRemoteDataDataSource: GameRemoteDataSource) = GameRepository(gameRemoteDataDataSource)

/*    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }*/
}