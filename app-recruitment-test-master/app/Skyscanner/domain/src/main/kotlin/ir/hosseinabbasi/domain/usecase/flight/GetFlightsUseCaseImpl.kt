package ir.hosseinabbasi.domain.usecase.flight

import io.reactivex.Flowable
import ir.hosseinabbasi.domain.common.transformer.FTransformer
import ir.hosseinabbasi.domain.entity.Entity
import ir.hosseinabbasi.domain.repository.flight.FlightRepository

/**
 * Created by Dr.jacky on 10/31/2018.
 */
/**
 * Flight use case implementation
 */
class GetFlightsUseCaseImpl(
    private val transformerFlowable: FTransformer<Entity.Flight>,
    private val repository: FlightRepository
) : GetFlightsUseCase {

    /**
     * Get all of flights use case implementation
     *
     * @return a Flowable that emits flights
     */
    override fun getFlights(): Flowable<Entity.Flight> =
        repository.getFlights().compose(transformerFlowable)
}