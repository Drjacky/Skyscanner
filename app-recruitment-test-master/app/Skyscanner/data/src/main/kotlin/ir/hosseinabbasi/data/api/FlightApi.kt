package ir.hosseinabbasi.data.api

import com.google.gson.annotations.SerializedName
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.adapter.rxjava2.Result
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Dr.jacky on 11/1/2018.
 */
/**
 * Flights api
 */
interface FlightApi {

    /**
     * Create a session.
     * The Live Pricing Service Session must be created before any pricing data can be obtained.
     */
    @FormUrlEncoded
    @POST("pricing")
    fun createSession(
        @Field("country") country: String = COUNTRY,
        @Field("currency") currency: String = CURRENCY_USD,
        @Field("locale") locale: String = LOCALE_US,
        @Field("originPlace") originPlace: String = EDINBURGH_ID,
        @Field("destinationPlace") destinationPlace: String = LONDON_ID,
        @Field("outboundDate") outboundDate: String,
        @Field("inboundDate") inboundDate: String,
        @Field("cabinClass") cabinClass: String = CABIN_CLASS,
        @Field("adults") adults: Int = 1,
        @Field("children") children: Int = 0,
        @Field("infants") infants: Int = 0,
        @Field("apiKey") apiKey: String
    ): Observable<Result<Any>>

    /**
     * Get all flights
     *
     * @return a Single that emits flights
     */
    fun getFlights(): Single<Dto.Flight>

    /**
     * Flight DTO
     */
    sealed class Dto {

        data class Agent(
            @SerializedName("Id")
            val id: Int,
            @SerializedName("Name")
            val name: String,
            @SerializedName("ImageUrl")
            val imageUrl: String,
            @SerializedName("Status")
            val status: String,
            @SerializedName("OptimisedForMobile")
            val optimisedForMobile: Boolean,
            @SerializedName("BookingNumber")
            val bookingNumber: String,
            @SerializedName("Type")
            val type: String
        )

        data class BookingDetailsLink(
            @SerializedName("Uri")
            val uri: String,
            @SerializedName("Body")
            val body: String,
            @SerializedName("Method")
            val method: String
        )

        data class Carrier(
            @SerializedName("Id")
            val id: Int,
            @SerializedName("Code")
            val code: String,
            @SerializedName("Name")
            val name: String,
            @SerializedName("ImageUrl")
            val imageUrl: String,
            @SerializedName("DisplayCode")
            val displayCode: String
        )

        data class Currency(
            @SerializedName("Code")
            val code: String,
            @SerializedName("Symbol")
            val symbol: String,
            @SerializedName("ThousandsSeparator")
            val thousandsSeparator: String,
            @SerializedName("DecimalSeparator")
            val decimalSeparator: String,
            @SerializedName("SymbolOnLeft")
            val symbolOnLeft: Boolean,
            @SerializedName("SpaceBetweenAmountAndSymbol")
            val spaceBetweenAmountAndSymbol: Boolean,
            @SerializedName("RoundingCoefficient")
            val roundingCoefficient: Int,
            @SerializedName("DecimalDigits")
            val decimalDigits: Int
        )

        data class FlightNumber(
            @SerializedName("FlightNumber")
            val flightNumber: String,
            @SerializedName("CarrierId")
            val carrierId: Int
        )

        data class Itinerary(
            @SerializedName("OutboundLegId")
            val outboundLegId: String,
            @SerializedName("InboundLegId")
            val inboundLegId: String,
            @SerializedName("PricingOptions")
            val pricingOptions: List<PricingOption>,
            @SerializedName("BookingDetailsLink")
            val bookingDetailsLink: BookingDetailsLink
        )

        data class Leg(
            @SerializedName("Id")
            val id: String,
            @SerializedName("SegmentIds")
            val segmentIds: List<Int>,
            @SerializedName("OriginStation")
            val originStation: Int,
            @SerializedName("DestinationStation")
            val destinationStation: Int,
            @SerializedName("Departure")
            val departure: String,
            @SerializedName("Arrival")
            val arrival: String,
            @SerializedName("Duration")
            val duration: Int,
            @SerializedName("JourneyMode")
            val journeyMode: String,
            @SerializedName("Stops")
            val stops: List<Int>,
            @SerializedName("Carriers")
            val carriers: List<Int>,
            @SerializedName("OperatingCarriers")
            val operatingCarriers: List<Int>,
            @SerializedName("Directionality")
            val directionality: String,
            @SerializedName("FlightNumbers")
            val flightNumbers: List<FlightNumber>
        )

        data class Place(
            @SerializedName("Id")
            val id: Int,
            @SerializedName("ParentId")
            val parentId: Int,
            @SerializedName("Code")
            val code: String,
            @SerializedName("Type")
            val type: String,
            @SerializedName("Name")
            val name: String
        )

        data class PricingOption(
            @SerializedName("Agents")
            val agents: List<Int>,
            @SerializedName("QuoteAgeInMinutes")
            val quoteAgeInMinutes: Int,
            @SerializedName("Price")
            val price: Double,
            @SerializedName("DeepLinkUrl")
            val deepLinkUrl: String
        )

        data class Query(
            @SerializedName("Country")
            val country: String,
            @SerializedName("Currency")
            val currency: String,
            @SerializedName("Locale")
            val locale: String,
            @SerializedName("Adults")
            val adults: Int,
            @SerializedName("Children")
            val children: Int,
            @SerializedName("Infants")
            val infants: Int,
            @SerializedName("OriginPlace")
            val originPlace: String,
            @SerializedName("DestinationPlace")
            val destinationPlace: String,
            @SerializedName("OutboundDate")
            val outboundDate: String,
            @SerializedName("InboundDate")
            val inboundDate: String,
            @SerializedName("LocationSchema")
            val locationSchema: String,
            @SerializedName("CabinClass")
            val cabinClass: String,
            @SerializedName("GroupPricing")
            val groupPricing: Boolean
        )

        data class Segment(
            @SerializedName("Id")
            val id: Int,
            @SerializedName("OriginStation")
            val originStation: Int,
            @SerializedName("DestinationStation")
            val destinationStation: Int,
            @SerializedName("DepartureDateTime")
            val departureDateTime: String,
            @SerializedName("ArrivalDateTime")
            val arrivalDateTime: String,
            @SerializedName("Carrier")
            val carrier: Int,
            @SerializedName("OperatingCarrier")
            val operatingCarrier: Int,
            @SerializedName("Duration")
            val duration: Int,
            @SerializedName("FlightNumber")
            val flightNumber: String,
            @SerializedName("JourneyMode")
            val journeyMode: String,
            @SerializedName("Directionality")
            val directionality: String
        )

        data class Flight(
            @SerializedName("SessionKey")
            val sessionKey: String,
            @SerializedName("Query")
            val query: Query,
            @SerializedName("Status")
            val status: String,
            @SerializedName("Itineraries")
            val itineraries: List<Itinerary>,
            @SerializedName("Legs")
            val legs: List<Leg>,
            @SerializedName("Segments")
            val segments: List<Segment>,
            @SerializedName("Carriers")
            val carriers: List<Carrier>,
            @SerializedName("Agents")
            val agents: List<Agent>,
            @SerializedName("Places")
            val places: List<Place>,
            @SerializedName("Currencies")
            val currencies: List<Currency>
        )
    }

}

/**
 * Constant values for session request
 */
private const val COUNTRY = "GB"
private const val CURRENCY_USD = "GBP"
private const val LOCALE_US = "en-US"
private const val EDINBURGH_ID = "EDIN-sky"
private const val LONDON_ID = "LOND-sky"
private const val CABIN_CLASS = "economy"
