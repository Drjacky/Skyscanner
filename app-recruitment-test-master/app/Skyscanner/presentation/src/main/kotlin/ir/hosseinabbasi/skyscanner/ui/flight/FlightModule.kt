package ir.hosseinabbasi.skyscanner.ui.flight

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ir.hosseinabbasi.data.api.FlightApi
import ir.hosseinabbasi.data.datasource.flight.FlightApiDataSource
import ir.hosseinabbasi.data.datasource.flight.FlightApiDataSourceImpl
import ir.hosseinabbasi.data.datasource.flight.FlightDatabaseDataSource
import ir.hosseinabbasi.data.datasource.flight.FlightDatabaseDataSourceImpl
import ir.hosseinabbasi.data.db.flight.FlightDao
import ir.hosseinabbasi.data.repository.flight.FlightRepositoryImpl
import ir.hosseinabbasi.domain.repository.flight.FlightRepository
import ir.hosseinabbasi.domain.usecase.flight.GetFlightsUseCase
import ir.hosseinabbasi.domain.usecase.flight.GetFlightsUseCaseImpl
import ir.hosseinabbasi.skyscanner.common.transformer.AsyncFTransformer
import ir.hosseinabbasi.skyscanner.common.transformer.AsyncOTransformer
import ir.hosseinabbasi.skyscanner.di.scope.ViewModelKey

/**
 * Created by Dr.jacky on 10/31/2018.
 */
@Module(
    includes = [
        FlightModule.FlightVM::class]
)
abstract class FlightModule {

    @ContributesAndroidInjector
    abstract fun flightFragment(): FlightFragment

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun provideDatabaseSource(flightDao: FlightDao): FlightDatabaseDataSource =
            FlightDatabaseDataSourceImpl(flightDao)

        @JvmStatic
        @Provides
        fun provideApiSource(api: FlightApi): FlightApiDataSource = FlightApiDataSourceImpl(api)

        @JvmStatic
        @Provides
        fun provideRepository(
            apiSource: FlightApiDataSource,
            databaseSource: FlightDatabaseDataSource
        ): FlightRepository {
            return FlightRepositoryImpl(apiSource, databaseSource)
        }

        @JvmStatic
        @Provides
        fun provideGetFlightsUseCaseImpl(repository: FlightRepository): GetFlightsUseCase =
            GetFlightsUseCaseImpl(AsyncFTransformer(), AsyncOTransformer(), repository)
    }

    @Module
    abstract class FlightVM {
        @Binds
        @IntoMap
        @ViewModelKey(FlightViewModel::class)
        internal abstract fun bindFlightViewModel(viewModel: FlightViewModel): ViewModel
    }
}