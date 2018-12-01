package ir.hosseinabbasi.data.repository.flight

import io.reactivex.Flowable
import ir.hosseinabbasi.data.datasource.flight.FlightApiDataSource
import ir.hosseinabbasi.data.datasource.flight.FlightDatabaseDataSource
import ir.hosseinabbasi.data.repository.BaseRepositoryImpl
import ir.hosseinabbasi.domain.common.ResultState
import ir.hosseinabbasi.domain.entity.Entity
import ir.hosseinabbasi.domain.repository.flight.FlightRepository

/**
 * Created by Dr.jacky on 11/5/2018.
 */
class FlightRepositoryImpl(
    private val apiSource: FlightApiDataSource,
    private val databaseSource: FlightDatabaseDataSource
) : BaseRepositoryImpl<Entity.Flight>(), FlightRepository {

    /**
     * Create session to get a Location from the response's header
     */
    override fun createSession(outboundDate: String, inboundDate: String, apiKey: String) =
        apiSource.createSession(outboundDate, inboundDate, apiKey)

    /**
     * Perform implementation
     */
    override fun getFlights(url: String): Flowable<ResultState<List<Entity.Flight>>> =
        performList(
            databaseSource.getFlights(),
            apiSource.getFlights(url),
            persist = databaseSource::persist
        )
}