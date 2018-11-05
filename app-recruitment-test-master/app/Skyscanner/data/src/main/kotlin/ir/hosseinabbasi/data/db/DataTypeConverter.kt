package ir.hosseinabbasi.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ir.hosseinabbasi.data.db.flight.FlightData

/**
 * Created by Dr.jacky on 11/1/2018.
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

    /*@TypeConverter
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
    }*/
}