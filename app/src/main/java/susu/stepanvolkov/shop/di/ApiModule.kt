package susu.stepanvolkov.shop.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import susu.stepanvolkov.shop.model.Api
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideApi(): Api = Retrofit.Builder()
        .baseUrl("http://192.168.0.105:5000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Api::class.java)
}
