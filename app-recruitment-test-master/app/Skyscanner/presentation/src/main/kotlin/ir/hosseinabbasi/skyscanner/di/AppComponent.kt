package ir.hosseinabbasi.skyscanner.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ir.hosseinabbasi.skyscanner.BaseApplication
import ir.hosseinabbasi.skyscanner.ui.MainModule
import javax.inject.Singleton

/**
 * Created by Dr.jacky on 11/4/2018.
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        AppModule::class,
        MainModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<BaseApplication>()
}