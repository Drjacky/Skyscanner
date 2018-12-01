package ir.hosseinabbasi.domain.entity

/**
 * Created by Dr.jacky on 10/31/2018.
 */
sealed class Entity {

    data class Agent(
        val id: Int,
        val name: String,
        val imageUrl: String,
        val status: String,
        val optimisedForMobile: Boolean,
        val bookingNumber: String,
        val type: String
    ) : Entity()

    data class BookingDetailsLink(
        val uri: String,
        val body: String,
        val method: String
    ) : Entity()

    data class Carrier(
        val id: Int,
        val code: String,
        val name: String,
        val imageUrl: String,
        val displayCode: String
    ) : Entity()

    data class Currency(
        val code: String,
        val symbol: String,
        val thousandsSeparator: String,
        val decimalSeparator: String,
        val symbolOnLeft: Boolean,
        val spaceBetweenAmountAndSymbol: Boolean,
        val roundingCoefficient: Int,
        val decimalDigits: Int
    ) : Entity()

    data class FlightNumber(
        val flightNumber: String,
        val carrierId: Int
    ) : Entity()

    data class Itinerary(
        val outboundLegId: String,
        val inboundLegId: String,
        val pricingOptions: List<PricingOption>,
        val bookingDetailsLink: BookingDetailsLink
    ) : Entity()

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
        val flightNumbers: List<FlightNumber>
    ) : Entity()

    data class Place(
        val id: Int,
        val parentId: Int,
        val code: String,
        val type: String,
        val name: String
    ) : Entity()

    data class PricingOption(
        val agents: List<Int>,
        val quoteAgeInMinutes: Int,
        val price: Double,
        val deepLinkUrl: String
    ) : Entity()

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
    ) : Entity()

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
    ) : Entity()

    data class Flight(
        val flightLocalId: Long?,
        val sessionKey: String,
        val query: Entity.Query,
        val status: String,
        val itineraries: List<Itinerary>,
        val legs: List<Leg>,
        val segments: List<Segment>,
        val carriers: List<Carrier>,
        val agents: List<Agent>,
        val places: List<Place>,
        val currencies: List<Currency>
    ) : Entity()
}