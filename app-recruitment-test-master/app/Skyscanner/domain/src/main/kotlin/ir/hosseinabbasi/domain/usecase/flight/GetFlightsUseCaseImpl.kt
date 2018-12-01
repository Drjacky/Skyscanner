package ir.hosseinabbasi.domain.usecase.flight

import io.reactivex.Flowable
import io.reactivex.Observable
import ir.hosseinabbasi.domain.common.ResultState
import ir.hosseinabbasi.domain.common.transformer.FTransformer
import ir.hosseinabbasi.domain.common.transformer.OTransformer
import ir.hosseinabbasi.domain.entity.Entity
import ir.hosseinabbasi.domain.repository.flight.FlightRepository
import retrofit2.adapter.rxjava2.Result

/**
 * Created by Dr.jacky on 10/31/2018.
 */
/**
 * Flight use case implementation
 */
class GetFlightsUseCaseImpl(
    private val transformerFlowable: FTransformer<ResultState<List<Entity.Flight>>>,
    private val transformerObservable: OTransformer<Result<Any>>,
    private val repository: FlightRepository
) : GetFlightsUseCase {

    /**
     * Create session use case implementation
     *
     * @return a Location in its header
     */
    override fun createSession(outboundDate: String, inboundDate: String, apiKey: String): Observable<Result<Any>> =
        repository.createSession(outboundDate, inboundDate, apiKey).compose(transformerObservable)


    /**
     * Get all of flights use case implementation
     *
     * @return a Flowable that emits flights
     */
    override fun getFlights(url: String): Flowable<ResultState<List<Entity.Flight>>> =
        repository.getFlights(url).compose(transformerFlowable)
}