package ir.hosseinabbasi.domain.usecase.flight

import io.reactivex.Flowable
import io.reactivex.Observable
import ir.hosseinabbasi.domain.common.ResultState
import ir.hosseinabbasi.domain.entity.Entity
import ir.hosseinabbasi.domain.usecase.BaseUseCase
import retrofit2.adapter.rxjava2.Result

/**
 * Created by Dr.jacky on 10/31/2018.
 */
/**
 * Flight use case
 */
interface GetFlightsUseCase : BaseUseCase {

    /**
     * Create session
     */
    fun createSession(outboundDate: String, inboundDate: String, apiKey: String): Observable<Result<Any>>

    /**
     * Get all of flights
     */
    fun getFlights(url: String): Flowable<ResultState<List<Entity.Flight>>>
}