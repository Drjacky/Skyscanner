package ir.hosseinabbasi.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.hosseinabbasi.data.db.flight.FlightDao
import ir.hosseinabbasi.data.db.flight.FlightData

/**
 * Created by Dr.jacky on 11/1/2018.
 */
/**
 * Database class with all of its dao classes
 */
@Database(
    entities = [
        FlightData.Flight::class,
        FlightData.Itinerary::class,
        FlightData.Leg::class,
        FlightData.Segment::class,
        FlightData.Carrier::class,
        FlightData.Agent::class,
        FlightData.Place::class,
        FlightData.Currency::class
    ], version = 1, exportSchema = false
)
@TypeConverters(DataTypeConverter::class)
abstract class MyDatabase : RoomDatabase() {

    abstract fun flightDao(): FlightDao
}