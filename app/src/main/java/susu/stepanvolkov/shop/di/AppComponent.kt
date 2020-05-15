package susu.stepanvolkov.shop.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import susu.stepanvolkov.shop.activity.CartActivity
import susu.stepanvolkov.shop.activity.CatalogActivity
import susu.stepanvolkov.shop.activity.CheckoutActivity
import susu.stepanvolkov.shop.activity.ProductDetailActivity
import javax.inject.Singleton

@Component(
    modules = [
        PreferencesModule::class,
        ApiModule::class
    ]
)
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }

    fun inject(activity: CatalogActivity)
    fun inject(activity: ProductDetailActivity)
    fun inject(activity: CartActivity)
    fun inject(activity: CheckoutActivity)
}