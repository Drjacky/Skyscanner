package ir.hosseinabbasi.data.datasource.flight

import io.reactivex.Flowable
import ir.hosseinabbasi.data.db.flight.FlightDao
import ir.hosseinabbasi.data.mapper.map
import ir.hosseinabbasi.domain.entity.Entity

/**
 * Created by Dr.jacky on 11/2/2018.
 */
/**
 * Flight database data source implementation
 */
class FlightDatabaseDataSourceImpl(private val flightDao: FlightDao) : FlightDatabaseDataSource {

    /**
     * Get all of flights from database implementation
     */
    override fun getFlights(): Flowable<List<Entity.Flight>> {
        return flightDao.selectAll().map { it -> it.map { it.map() } }
    }

    /**
     * Persist all of flights in local database implementation
     */
    override fun persist(flight: List<Entity.Flight>) {
        return flightDao.persist(flight)
    }
}