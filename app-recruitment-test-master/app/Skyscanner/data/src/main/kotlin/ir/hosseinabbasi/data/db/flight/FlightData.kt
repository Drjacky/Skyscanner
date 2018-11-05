package ir.hosseinabbasi.data.db.flight

import androidx.room.*

/**
 * Created by Dr.jacky on 11/1/2018.
 */
/**
 * Flight data class
 */
sealed class FlightData {

    @Entity(tableName = "agent")
    data class Agent(
        @ColumnInfo(name = "agent_local_id") @PrimaryKey(autoGenerate = true)
        var agentLocalId: Long?,
        @ColumnInfo(name = "id")
        val id: Int,
        @ColumnInfo(name = "name")
        val name: String,
        @ColumnInfo(name = "image_url")
        val imageUrl: String,
        @ColumnInfo(name = "status")
        val status: String,
        @ColumnInfo(name = "optimised_for_mobile")
        val optimisedForMobile: Boolean,
        @ColumnInfo(name = "booking_number")
        val bookingNumber: String,
        @ColumnInfo(name = "type")
        val type: String,
        @ColumnInfo(name = "flight_local_id")
        val flightLocalId: Long?
    )

    @Entity(tableName = "booking_details_link")
    data class BookingDetailsLink(
        @ColumnInfo(name = "booking_details_link_local_id") @PrimaryKey(autoGenerate = true)
        var bookingDetailsLinkLocalId: Long?,
        @ColumnInfo(name = "uri")
        val uri: String,
        @ColumnInfo(name = "body")
        val body: String,
        @ColumnInfo(name = "method")
        val method: String,
        @ColumnInfo(name = "itinerary_id")
        val itineraryLocalId: Long?
    )

    @Entity(tableName = "carrier")
    data class Carrier(
        @ColumnInfo(name = "carrier_id") @PrimaryKey(autoGenerate = true)
        var carrierLocalId: Long?,
        @ColumnInfo(name = "id")
        val id: Int,
        @ColumnInfo(name = "code")
        val code: String,
        @ColumnInfo(name = "name")
        val name: String,
        @ColumnInfo(name = "image_url")
        val imageUrl: String,
        @ColumnInfo(name = "display_code")
        val displayCode: String,
        @ColumnInfo(name = "flight_local_id")
        val flightLocalId: Long?
    )

    @Entity(tableName = "currency")
    data class Currency(
        @ColumnInfo(name = "currency_id") @PrimaryKey(autoGenerate = true)
        var currencyLocalId: Long?,
        @ColumnInfo(name = "code")
        val code: String,
        @ColumnInfo(name = "symbol")
        val symbol: String,
        @ColumnInfo(name = "thousands_separator")
        val thousandsSeparator: String,
        @ColumnInfo(name = "decimal_separator")
        val decimalSeparator: String,
        @ColumnInfo(name = "symbol_on_left")
        val symbolOnLeft: Boolean,
        @ColumnInfo(name = "space_between_amount_and_symbol")
        val spaceBetweenAmountAndSymbol: Boolean,
        @ColumnInfo(name = "rounding_coefficient")
        val roundingCoefficient: Int,
        @ColumnInfo(name = "decimal_digits")
        val decimalDigits: Int,
        @ColumnInfo(name = "flight_local_id")
        val flightLocalId: Long?
    )

    @Entity(tableName = "flight_number")
    data class FlightNumber(
        @ColumnInfo(name = "flight_number_local_id") @PrimaryKey(autoGenerate = true)
        var flightNumberLocalId: Long?,
        @ColumnInfo(name = "flight_number")
        val flightNumber: String,
        @ColumnInfo(name = "carrier_id")
        val carrierId: Int,
        @ColumnInfo(name = "leg_local_id")
        val legLocalId: Long?
    )

    @Entity(tableName = "itinerary")
    data class Itinerary(
        @ColumnInfo(name = "itinerary_local_id") @PrimaryKey(autoGenerate = true)
        var itineraryLocalId: Long?,
        @ColumnInfo(name = "outbound_leg_id")
        val outboundLegId: String,
        @ColumnInfo(name = "inbound_leg_id")
        val inboundLegId: String,
        @ColumnInfo(name = "flight_local_id")
        val flightLocalId: Long?
    )

    @Entity(tableName = "leg")
    data class Leg(
        @ColumnInfo(name = "leg_local_id") @PrimaryKey(autoGenerate = true)
        var legLocalId: Long?,
        @ColumnInfo(name = "id")
        val id: String,
        @ColumnInfo(name = "segment_ids")
        val segmentIds: List<Int>,
        @ColumnInfo(name = "origin_station")
        val originStation: Int,
        @ColumnInfo(name = "destination_station")
        val destinationStation: Int,
        @ColumnInfo(name = "departure")
        val departure: String,
        @ColumnInfo(name = "arrival")
        val arrival: String,
        @ColumnInfo(name = "duration")
        val duration: Int,
        @ColumnInfo(name = "journey_mode")
        val journeyMode: String,
        @ColumnInfo(name = "stops")
        val stops: List<Int>,
        @ColumnInfo(name = "carriers")
        val carriers: List<Int>,
        @ColumnInfo(name = "operating_carriers")
        val operatingCarriers: List<Int>,
        @ColumnInfo(name = "directionality")
        val directionality: String,
        @ColumnInfo(name = "flight_local_id")
        val flightLocalId: Long?
    )

    @Entity(tableName = "segment")
    data class Segment(
        @ColumnInfo(name = "segment_local_id") @PrimaryKey(autoGenerate = true)
        var segmentLocalId: Long?,
        @ColumnInfo(name = "id")
        val id: Int,
        @ColumnInfo(name = "origin_station")
        val originStation: Int,
        @ColumnInfo(name = "destination_station")
        val destinationStation: Int,
        @ColumnInfo(name = "departure_date_time")
        val departureDateTime: String,
        @ColumnInfo(name = "arrival_date_time")
        val arrivalDateTime: String,
        @ColumnInfo(name = "carrier")
        val carrier: Int,
        @ColumnInfo(name = "operating_carrier")
        val operatingCarrier: Int,
        @ColumnInfo(name = "duration")
        val duration: Int,
        @ColumnInfo(name = "flight_number")
        val flightNumber: String,
        @ColumnInfo(name = "journey_mode")
        val journeyMode: String,
        @ColumnInfo(name = "directionality")
        val directionality: String,
        @ColumnInfo(name = "flight_local_id")
        val flightLocalId: Long?
    )

    @Entity(tableName = "place")
    data class Place(
        @ColumnInfo(name = "place_local_id") @PrimaryKey(autoGenerate = true)
        var placeLocalId: Long?,
        @ColumnInfo(name = "id")
        val id: Int,
        @ColumnInfo(name = "parent_id")
        val parentId: Int,
        @ColumnInfo(name = "code")
        val code: String,
        @ColumnInfo(name = "type")
        val type: String,
        @ColumnInfo(name = "name")
        val name: String,
        @ColumnInfo(name = "flight_local_id")
        val flightLocalId: Long?
    )

    @Entity(tableName = "pricing_option")
    data class PricingOption(
        @ColumnInfo(name = "pricing_option_local_id") @PrimaryKey(autoGenerate = true)
        var pricingOptionLocalId: Long?,
        @ColumnInfo(name = "agents")
        val agents: List<Int>,
        @ColumnInfo(name = "quote_age_in_minutes")
        val quoteAgeInMinutes: Int,
        @ColumnInfo(name = "price")
        val price: Double,
        @ColumnInfo(name = "deep_link_url")
        val deepLinkUrl: String,
        @ColumnInfo(name = "itinerary_local_id")
        val itineraryLocalId: Long?
    )

    @Entity(tableName = "query")
    data class Query(
        @ColumnInfo(name = "query_local_id") @PrimaryKey(autoGenerate = true)
        var queryLocalId: Long?,
        @ColumnInfo(name = "country")
        val country: String,
        @ColumnInfo(name = "currency")
        val currency: String,
        @ColumnInfo(name = "locale")
        val locale: String,
        @ColumnInfo(name = "adults")
        val adults: Int,
        @ColumnInfo(name = "children")
        val children: Int,
        @ColumnInfo(name = "infants")
        val infants: Int,
        @ColumnInfo(name = "origin_place")
        val originPlace: String,
        @ColumnInfo(name = "destination_place")
        val destinationPlace: String,
        @ColumnInfo(name = "outbound_date")
        val outboundDate: String,
        @ColumnInfo(name = "inbound_date")
        val inboundDate: String,
        @ColumnInfo(name = "location_schema")
        val locationSchema: String,
        @ColumnInfo(name = "cabin_class")
        val cabinClass: String,
        @ColumnInfo(name = "group_pricing")
        val groupPricing: Boolean
    )

    @Entity(tableName = "flight")
    data class Flight(
        @ColumnInfo(name = "flight_local_id") @PrimaryKey(autoGenerate = true)
        var flightLocalId: Long?,
        @ColumnInfo(name = "session_key")
        val sessionKey: String,
        @Embedded val query: Query,
        @ColumnInfo(name = "status")
        val status: String
    ) : FlightData()

    /**
     * The result table of the database queries
     */
    data class Result(
        @Embedded val flight: FlightData.Flight,
        @Relation(
            parentColumn = "flight_local_id",
            entityColumn = "flight_local_id",
            entity = FlightData.Itinerary::class
        ) val itineraries: List<FlightData.Itinerary>,
        @Relation(
            parentColumn = "flight_local_id",
            entityColumn = "flight_local_id",
            entity = FlightData.Leg::class
        ) val legs: List<FlightData.Leg>,
        @Relation(
            parentColumn = "flight_local_id",
            entityColumn = "flight_local_id",
            entity = FlightData.Segment::class
        ) val segments: List<FlightData.Segment>,
        @Relation(
            parentColumn = "flight_local_id",
            entityColumn = "flight_local_id",
            entity = FlightData.Carrier::class
        ) val carriers: List<FlightData.Carrier>,
        @Relation(
            parentColumn = "flight_local_id",
            entityColumn = "flight_local_id",
            entity = FlightData.Agent::class
        ) val agents: List<FlightData.Agent>,
        @Relation(
            parentColumn = "flight_local_id",
            entityColumn = "flight_local_id",
            entity = FlightData.Place::class
        ) val places: List<FlightData.Place>,
        @Relation(
            parentColumn = "flight_local_id",
            entityColumn = "flight_local_id",
            entity = FlightData.Currency::class
        ) val currencies: List<FlightData.Currency>
    ) : FlightData()
}