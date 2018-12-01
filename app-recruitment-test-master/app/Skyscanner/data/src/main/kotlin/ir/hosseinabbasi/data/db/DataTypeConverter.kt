package ir.hosseinabbasi.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ir.hosseinabbasi.data.db.flight.FlightData

/**
 * Created by Dr.jacky on 11/1/2018.
 */
/**
 * Type converters to convert unknown objects for database
 */
class DataTypeConverter {

    @TypeConverter
    fun fromIntList(value: List<Int>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Int>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toIntList(value: String): List<Int> {
        val gson = Gson()
        val type = object : TypeToken<List<Int>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromItineraryList(itineraryList: List<FlightData.Itinerary>?): String? {
        if (itineraryList == null) return null

        val gson = Gson()
        val type = object : TypeToken<List<FlightData.Itinerary>>() {}.type
        return gson.toJson(itineraryList, type)
    }

    @TypeConverter
    fun toItineraryList(itineraryString: String?): List<FlightData.Itinerary>? {
        if (itineraryString == null) return null

        val gson = Gson()
        val type = object : TypeToken<List<FlightData.Itinerary>>() {}.type
        return gson.fromJson(itineraryString, type)
    }

    @TypeConverter
    fun fromQuery(query: FlightData.Query?): String? {
        if (query == null) return null

        val gson = Gson()
        val type = object : TypeToken<FlightData.Query>() {}.type
        return gson.toJson(query, type)
    }

    @TypeConverter
    fun toQuery(queryString: String?): FlightData.Query? {
        if (queryString == null) return null

        val gson = Gson()
        val type = object : TypeToken<FlightData.Query>() {}.type
        return gson.fromJson(queryString, type)
    }

    @TypeConverter
    fun fromSegmentList(segmentList: List<FlightData.Segment>?): String? {
        if (segmentList == null) return null

        val gson = Gson()
        val type = object : TypeToken<List<FlightData.Segment>>() {}.type
        return gson.toJson(segmentList, type)
    }

    @TypeConverter
    fun toSegmentList(segmentString: String?): List<FlightData.Segment>? {
        if (segmentString == null) return null

        val gson = Gson()
        val type = object : TypeToken<List<FlightData.Segment>>() {}.type
        return gson.fromJson(segmentString, type)
    }

    @TypeConverter
    fun fromCarrierList(carrierList: List<FlightData.Carrier>?): String? {
        if (carrierList == null) return null

        val gson = Gson()
        val type = object : TypeToken<List<FlightData.Carrier>>() {}.type
        return gson.toJson(carrierList, type)
    }

    @TypeConverter
    fun toCarrierList(carrierString: String?): List<FlightData.Carrier>? {
        if (carrierString == null) return null

        val gson = Gson()
        val type = object : TypeToken<List<FlightData.Carrier>>() {}.type
        return gson.fromJson(carrierString, type)
    }

    @TypeConverter
    fun toAgentList(agentString: String?): List<FlightData.Agent>? {
        if (agentString == null) return null

        val gson = Gson()
        val type = object : TypeToken<List<FlightData.Agent>>() {}.type
        return gson.fromJson(agentString, type)
    }

    @TypeConverter
    fun fromAgentList(agentList: List<FlightData.Agent>?): String? {
        if (agentList == null) return null

        val gson = Gson()
        val type = object : TypeToken<List<FlightData.Agent>>() {}.type
        return gson.toJson(agentList, type)
    }

    @TypeConverter
    fun toPlaceList(placeString: String?): List<FlightData.Place>? {
        if (placeString == null) return null

        val gson = Gson()
        val type = object : TypeToken<List<FlightData.Place>>() {}.type
        return gson.fromJson(placeString, type)
    }

    @TypeConverter
    fun fromPlaceList(placeList: List<FlightData.Place>?): String? {
        if (placeList == null) return null

        val gson = Gson()
        val type = object : TypeToken<List<FlightData.Place>>() {}.type
        return gson.toJson(placeList, type)
    }

    @TypeConverter
    fun toCurrencyList(currencyString: String?): List<FlightData.Currency>? {
        if (currencyString == null) return null

        val gson = Gson()
        val type = object : TypeToken<List<FlightData.Currency>>() {}.type
        return gson.fromJson(currencyString, type)
    }

    @TypeConverter
    fun fromCurrencyList(currencyList: List<FlightData.Currency>?): String? {
        if (currencyList == null) return null

        val gson = Gson()
        val type = object : TypeToken<List<FlightData.Currency>>() {}.type
        return gson.toJson(currencyList, type)
    }

    @TypeConverter
    fun fromPricingOptionList(pricingOptionList: List<FlightData.PricingOption>?): String? {
        if (pricingOptionList == null) return null

        val gson = Gson()
        val type = object : TypeToken<List<FlightData.PricingOption>>() {}.type
        return gson.toJson(pricingOptionList, type)
    }

    @TypeConverter
    fun toPricingOptionList(pricingOptionString: String?): List<FlightData.PricingOption>? {
        if (pricingOptionString == null) return null

        val gson = Gson()
        val type = object : TypeToken<List<FlightData.PricingOption>>() {}.type
        return gson.fromJson(pricingOptionString, type)
    }

    @TypeConverter
    fun fromLegList(legList: List<FlightData.Leg>?): String? {
        if (legList == null) return null

        val gson = Gson()
        val type = object : TypeToken<List<FlightData.Leg>>() {}.type
        return gson.toJson(legList, type)
    }

    @TypeConverter
    fun toLegList(legString: String?): List<FlightData.Leg>? {
        if (legString == null) return null

        val gson = Gson()
        val type = object : TypeToken<List<FlightData.Leg>>() {}.type
        return gson.fromJson(legString, type)
    }

    @TypeConverter
    fun fromBookingDetailsLink(bookingDetailsLink: FlightData.BookingDetailsLink?): String? {
        if (bookingDetailsLink == null) return null

        val gson = Gson()
        val type = object : TypeToken<FlightData.BookingDetailsLink>() {}.type
        return gson.toJson(bookingDetailsLink, type)
    }

    @TypeConverter
    fun toBookingDetailsLink(bookingDetailsLinkString: String?): FlightData.BookingDetailsLink? {
        if (bookingDetailsLinkString == null) return null

        val gson = Gson()
        val type = object : TypeToken<FlightData.BookingDetailsLink>() {}.type
        return gson.fromJson(bookingDetailsLinkString, type)
    }

    @TypeConverter
    fun fromFlightNumberList(flightNumberList: List<FlightData.FlightNumber>?): String? {
        if (flightNumberList == null) return null

        val gson = Gson()
        val type = object : TypeToken<List<FlightData.FlightNumber>>() {}.type
        return gson.toJson(flightNumberList, type)
    }

    @TypeConverter
    fun toFlightNumberList(flightNumberString: String?): List<FlightData.FlightNumber>? {
        if (flightNumberString == null) return null

        val gson = Gson()
        val type = object : TypeToken<List<FlightData.FlightNumber>>() {}.type
        return gson.fromJson(flightNumberString, type)
    }
}