package ir.hosseinabbasi.data.db.flight

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import io.reactivex.Flowable
import ir.hosseinabbasi.data.db.BaseDao
import ir.hosseinabbasi.data.mapper.map
import ir.hosseinabbasi.domain.entity.Entity

/**
 * Created by Dr.jacky on 11/1/2018.
 */
@Dao
interface FlightDao : BaseDao<FlightData.Flight> {

    @Query("SELECT * FROM flight ORDER BY flight_local_id")
    override fun selectAll(): Flowable<List<FlightData.Flight>>

    @Query("SELECT * FROM flight WHERE flight_local_id = :id")
    override fun select(id: Long): Flowable<FlightData.Flight>

    @Transaction
    fun persist(flight: List<Entity.Flight>) {
        insert(flight.map { it.map() })
    }

    @Query("DELETE FROM flight")
    override fun truncate()
}