package ir.hosseinabbasi.data.datasource.flight

import io.reactivex.Single
import ir.hosseinabbasi.data.api.FlightApi
import ir.hosseinabbasi.data.mapper.map
import ir.hosseinabbasi.domain.entity.Entity

/**
 * Created by Dr.jacky on 11/2/2018.
 */
/**
 * Flight network data source implementation
 */
class FlightApiDataSourceImpl(private val api: FlightApi) : FlightApiDataSource {

    /**
     * Get all of flights from network implementation
     */
    override fun getFlights(): Single<Entity.Flight> = api.getFlights().map(FlightApi.Dto.Flight::map)
}