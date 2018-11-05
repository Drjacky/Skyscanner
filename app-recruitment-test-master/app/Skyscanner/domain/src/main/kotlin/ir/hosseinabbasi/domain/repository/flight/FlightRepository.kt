package ir.hosseinabbasi.domain.repository.flight

import io.reactivex.Flowable
import ir.hosseinabbasi.domain.entity.Entity
import ir.hosseinabbasi.domain.repository.BaseRepository

/**
 * Created by Dr.jacky on 10/31/2018.
 */
interface FlightRepository : BaseRepository {

    /**
     * Get all flights from local database
     *
     * @return a Flowable that emits flights
     */
    fun getFlights(): Flowable<Entity.Flight>
}