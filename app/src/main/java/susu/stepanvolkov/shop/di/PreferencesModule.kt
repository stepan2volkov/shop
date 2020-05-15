package susu.stepanvolkov.shop.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import susu.stepanvolkov.shop.model.CartProductDAO
import susu.stepanvolkov.shop.model.CartProductDAOImpl

@Module
class PreferencesModule {
    @Provides
    fun providePreferences(context: Context): SharedPreferences =
        context.getSharedPreferences("data", Context.MODE_PRIVATE)

    @Provides
    fun provideCartProductDAO(preferences: SharedPreferences): CartProductDAO =
        CartProductDAOImpl(preferences)
}