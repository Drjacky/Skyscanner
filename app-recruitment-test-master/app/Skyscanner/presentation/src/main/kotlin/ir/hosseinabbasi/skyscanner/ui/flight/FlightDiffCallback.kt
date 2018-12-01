package ir.hosseinabbasi.skyscanner.ui.flight

import androidx.recyclerview.widget.DiffUtil
import ir.hosseinabbasi.domain.entity.Entity

/**
 * Created by Dr.jacky on 11/5/2018.
 */
class FlightDiffCallback : DiffUtil.ItemCallback<Entity.Flight>() {

    override fun areItemsTheSame(oldItem: Entity.Flight, newItem: Entity.Flight): Boolean =
        oldItem.sessionKey == newItem.sessionKey

    override fun areContentsTheSame(oldItem: Entity.Flight, newItem: Entity.Flight): Boolean =
        oldItem == newItem

    override fun getChangePayload(oldItem: Entity.Flight, newItem: Entity.Flight): Any? {
        // Return particular field for changed item.
        return super.getChangePayload(oldItem, newItem)
    }
}