package ir.hosseinabbasi.data.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by Dr.jacky on 11/1/2018.
 */
/**
 * Parent of all of dao classes
 */
interface BaseDao<T> {

    fun select(id: Long): Flowable<T>

    fun selectAll(): Flowable<List<T>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(t: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(ts: List<T>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(t: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(ts: List<T>)

    @Delete
    fun delete(t: T): Single<Int>

    @Delete
    fun delete(ts: List<T>)

    fun truncate()
}