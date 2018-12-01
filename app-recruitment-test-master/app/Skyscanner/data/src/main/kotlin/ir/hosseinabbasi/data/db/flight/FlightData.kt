package ir.hosseinabbasi.data.db.flight

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ir.hosseinabbasi.data.db.DataTypeConverter

/**
 * Created by Dr.jacky on 11/1/2018.
 */
/**
 * Flight data class
 */
sealed class FlightData {

    data class Agent(
        val id: Int,
        val name: String,
        val imageUrl: String,
        val status: String,
        val optimisedForMobile: Boolean,
        val bookingNumber: String,
        val type: String
    )

    data class BookingDetailsLink(
        val uri: String,
        val body: String,
        val method: String
    )

    data class Carrier(
        val id: Int,
        val code: String,
        val name: String,
        val imageUrl: String,
        val displayCode: String
    )

    data class Currency(
        val code: String,
        val symbol: String,
        val thousandsSeparator: String,
        val decimalSeparator: String,
        val symbolOnLeft: Boolean,
        val spaceBetweenAmountAndSymbol: Boolean,
        val roundingCoefficient: Int,
        val decimalDigits: Int
    )

    data class FlightNumber(
        val flightNumber: String,
        val carrierId: Int
    )

    data class Itinerary(
        val outboundLegId: String,
        val inboundLegId: String,
        val bookingDetailsLink: BookingDetailsLink,
        val pricingOption: List<PricingOption>
    )

    data class Leg(
        val id: String,
        val segmentIds: List<Int>,
        val originStation: Int,
        val destinationStation: Int,
        val departure: String,
        val arrival: String,
        val duration: Int,
        val journeyMode: String,
        val stops: List<Int>,
        val carriers: List<Int>,
        val operatingCarriers: List<Int>,
        val directionality: String,
        val flightNumber: List<FlightNumber>
    )

    data class Segment(
        val id: Int,
        val originStation: Int,
        val destinationStation: Int,
        val departureDateTime: String,
        val arrivalDateTime: String,
        val carrier: Int,
        val operatingCarrier: Int,
        val duration: Int,
        val flightNumber: String,
        val journeyMode: String,
        val directionality: String
    )

    data class Place(
        val id: Int,
        val parentId: Int,
        val code: String,
        val type: String,
        val name: String
    )

    data class PricingOption(
        val agents: List<Int>,
        val quoteAgeInMinutes: Int,
        val price: Double,
        val deepLinkUrl: String
    )

    data class Query(
        val country: String,
        val currency: String,
        val locale: String,
        val adults: Int,
        val children: Int,
        val infants: Int,
        val originPlace: String,
        val destinationPlace: String,
        val outboundDate: String,
        val inboundDate: String,
        val locationSchema: String,
        val cabinClass: String,
        val groupPricing: Boolean
    )

    /**
     * The result table of the database queries
     */
    @Entity(tableName = "flight")
    @TypeConverters(DataTypeConverter::class)
    data class Flight(
        @ColumnInfo(name = "flight_local_id") @PrimaryKey(autoGenerate = true)
        val flightLocalId: Long?,
        //@ColumnInfo(name = "session_key")
        val sessionKey: String,
        //@ColumnInfo(name = "query")
        val query: Query,
        //@ColumnInfo(name = "status")
        val status: String,
        //@ColumnInfo(name = "itineraries")
        val itineraries: List<FlightData.Itinerary>,
        //@ColumnInfo(name = "legs")
        val legs: List<FlightData.Leg>,
        //@ColumnInfo(name = "segments")
        val segments: List<FlightData.Segment>,
        //@ColumnInfo(name = "carriers")
        val carriers: List<FlightData.Carrier>,
        //@ColumnInfo(name = "entity")
        val agents: List<FlightData.Agent>,
        //@ColumnInfo(name = "places")
        val places: List<FlightData.Place>,
        //@ColumnInfo(name = "currencies")
        val currencies: List<FlightData.Currency>

    ) : FlightData()
}