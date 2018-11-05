package ir.hosseinabbasi.domain.usecase.flight

import io.reactivex.Flowable
import ir.hosseinabbasi.domain.entity.Entity
import ir.hosseinabbasi.domain.usecase.BaseUseCase

/**
 * Created by Dr.jacky on 10/31/2018.
 */
/**
 * Flight use case
 */
interface GetFlightsUseCase : BaseUseCase {

    /**
     * Get all of flights
     */
    fun getFlights(): Flowable<Entity.Flight>
}