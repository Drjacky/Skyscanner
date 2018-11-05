package ir.hosseinabbasi.skyscanner.ui

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.hosseinabbasi.skyscanner.ui.flight.FlightModule

/**
 * Created by Dr.jacky on 10/31/2018.
 */
@Module(includes = [FlightModule::class])
abstract class MainModule {

    @ContributesAndroidInjector
    abstract fun get(): MainActivity
}