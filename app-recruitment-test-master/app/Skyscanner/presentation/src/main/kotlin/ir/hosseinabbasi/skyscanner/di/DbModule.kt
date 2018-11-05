package ir.hosseinabbasi.skyscanner.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ir.hosseinabbasi.data.db.MyDatabase
import ir.hosseinabbasi.skyscanner.di.qualifier.ApplicationContext
import javax.inject.Singleton

/**
 * Created by Dr.jacky on 11/4/2018.
 */
@Module
class DbModule {

    @Singleton
    @Provides
    fun provideMyDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MyDatabase::class.java, "mydatabase")
            .build()

    @Singleton
    @Provides
    fun provideAlbumDao(myDatabase: MyDatabase) = myDatabase.flightDao()
}