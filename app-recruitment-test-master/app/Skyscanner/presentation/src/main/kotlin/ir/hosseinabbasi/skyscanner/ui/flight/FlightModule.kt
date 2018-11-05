package ir.hosseinabbasi.skyscanner.ui.flight

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ir.hosseinabbasi.data.db.flight.FlightDao

/**
 * Created by Dr.jacky on 10/31/2018.
 */
@Module(includes = [
    /*FlightModule.FlightVM::class*/])
abstract class FlightModule {

    /*@ContributesAndroidInjector
    abstract fun flightFragment(): FlightFragment

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun provideDatabaseSource(flightDao: FlightDao): AlbumsDatabaseDataSource = AlbumsDatabaseDataSourceImpl(albumDao)

        @JvmStatic
        @Provides
        fun provideApiSource(api: AlbumApi): AlbumsApiDataSource = AlbumsApiDataSourceImpl(api)

        @JvmStatic
        @Provides
        fun provideRepository(
            apiSource: AlbumsApiDataSource,
            databaseSource: AlbumsDatabaseDataSource
        ): AlbumsRepository {
            return AlbumsRepositoryImpl(apiSource, databaseSource)
        }

        @JvmStatic
        @Provides
        fun provideGetAlbumsUseCaseImpl(repository: AlbumsRepository): GetAlbumsUseCase = GetAlbumsUseCaseImpl(AsyncFTransformer(), AsyncSTransformer(), AsyncSTransformer(), repository)
    }

    @Module
    abstract class FlightVM {
        @Binds
        @IntoMap
        @ViewModelKey(HomeViewModel::class)
        internal abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
    }*/
}