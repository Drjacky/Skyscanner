package ir.hosseinabbasi.data.datasource.flight

import io.reactivex.Single
import ir.hosseinabbasi.domain.entity.Entity

/**
 * Created by Dr.jacky on 11/2/2018.
 */
/**
 * Flight network data source
 */
interface FlightApiDataSource {

    /**
     * Get all of flights from network
     *
     * @return a Single that emits flights
     */
    fun getFlights(): Single<Entity.Flight>
}