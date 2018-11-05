package ir.hosseinabbasi.data.datasource.flight

import io.reactivex.Flowable
import ir.hosseinabbasi.data.datasource.DataSource
import ir.hosseinabbasi.domain.entity.Entity

/**
 * Created by Dr.jacky on 11/2/2018.
 */
/**
 * Flight database data source
 */
interface FlightDatabaseDataSource : DataSource {

    /**
     * Get all of flights from database implementation
     *
     * @return a Flowable that emits flights
     */
    fun getFlights(): Flowable<Entity.Flight>

    /**
     * Persist all of flights in local database
     */
    fun replace(flight: Entity.Flight)
}