package ir.hosseinabbasi.data.datasource.flight

import io.reactivex.Observable
import io.reactivex.Single
import ir.hosseinabbasi.data.api.FlightApi
import ir.hosseinabbasi.data.mapper.map
import ir.hosseinabbasi.domain.entity.Entity
import retrofit2.adapter.rxjava2.Result

/**
 * Created by Dr.jacky on 11/2/2018.
 */
/**
 * Flight network data source implementation
 */
class FlightApiDataSourceImpl(private val api: FlightApi) : FlightApiDataSource {

    /**
     * Create session implementation
     */
    override fun createSession(outboundDate: String, inboundDate: String, apiKey: String): Observable<Result<Any>> =
        api.createSession(outboundDate = outboundDate, inboundDate = inboundDate, apiKey = apiKey)

    /**
     * Get all of flights from network implementation
     */
    override fun getFlights(url: String): Single<List<Entity.Flight>> =
        api.getFlights(url).map { it -> it.map { it.map() } }
}