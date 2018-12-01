package ir.hosseinabbasi.skyscanner.ui.flight

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ir.hosseinabbasi.domain.entity.Entity
import ir.hosseinabbasi.skyscanner.R
import ir.hosseinabbasi.skyscanner.common.extension.loadUrl
import ir.hosseinabbasi.skyscanner.databinding.ItemFlightBinding

/**
 * Created by Dr.jacky on 11/5/2018.
 */
class FlightListAdapter : ListAdapter<Entity.Flight, FlightListAdapter.DataHolder>(FlightDiffCallback()) {

    private lateinit var flight: Entity.Flight

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val bind: ItemFlightBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_flight, parent, false
        ) as ItemFlightBinding

        flight = getItem(0)

        return DataHolder(bind)
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val itinerary = flight.itineraries
        holder.bind(itinerary[position])
    }

    private fun getLeg(id: String): Entity.Leg? {
        for (leg in flight.legs) {
            if (leg.id == id) return leg
        }
        return null
    }

    private fun getCarrierImageUrl(id: Int?): String {
        for (carrier in flight.carriers) {
            if (carrier.id == id) return carrier.imageUrl
        }
        return ""
    }

    inner class DataHolder(private var itemFlightBinding: ItemFlightBinding) : RecyclerView.ViewHolder
        (itemFlightBinding.root) {

        fun bind(itinerary: Entity.Itinerary) {
            itemFlightBinding.itinerary = itinerary
            val leg = getLeg(itinerary.outboundLegId)
            val carrierImageUrl = getCarrierImageUrl(leg?.carriers?.get(0))
            itemFlightBinding.leg = leg
            itemFlightBinding.itemItineraryOutboundIcon.loadUrl(carrierImageUrl)
            itemFlightBinding.executePendingBindings()
        }
    }
}