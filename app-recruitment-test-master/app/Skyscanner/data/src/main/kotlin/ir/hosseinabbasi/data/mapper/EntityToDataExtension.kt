package ir.hosseinabbasi.data.mapper

import ir.hosseinabbasi.data.db.flight.FlightData
import ir.hosseinabbasi.domain.entity.Entity

/**
 * Created by Dr.jacky on 11/2/2018.
 */
/**
 * Extension class to map flight entity to flight data
 */
fun Entity.Flight.map() = FlightData.Flight(
    flightLocalId = flightLocalId,
    sessionKey = sessionKey,
    query = query.map(),
    status = status,
    itineraries = itineraries.map { it.map() },
    legs = legs.map { it.map() },
    segments = segments.map { it.map() },
    carriers = carriers.map { it.map() },
    agents = agents.map { it.map() },
    places = places.map { it.map() },
    currencies = currencies.map { it.map() }
)

/*fun Entity.Flight.map() = FlightData.Result(
    flight = FlightData.Flight(flightLocalId, sessionKey, query.map(), status),
    itineraries = itineraries.map { it.map() },
    legs = legs.map { it.map() },
    segments = segments.map { it.map() },
    carriers = carriers.map { it.map() },
    agents = agents.map { it.map() },
    places = places.map { it.map() },
    currencies = currencies.map { it.map() }
)*/

fun Entity.Query.map() = FlightData.Query(
    country = country,
    currency = currency,
    adults = adults,
    locale = locale,
    children = children,
    infants = infants,
    originPlace = originPlace,
    destinationPlace = destinationPlace,
    outboundDate = outboundDate,
    inboundDate = inboundDate,
    locationSchema = locationSchema,
    cabinClass = cabinClass,
    groupPricing = groupPricing
)

fun Entity.Itinerary.map() = FlightData.Itinerary(
    outboundLegId = outboundLegId,
    inboundLegId = inboundLegId,
    bookingDetailsLink = bookingDetailsLink.map(),
    pricingOption = pricingOptions.map { it.map() }
)

fun Entity.PricingOption.map() = FlightData.PricingOption(
    agents = agents,
    deepLinkUrl = deepLinkUrl,
    price = price,
    quoteAgeInMinutes = quoteAgeInMinutes
)

fun Entity.BookingDetailsLink.map() = FlightData.BookingDetailsLink(
    uri = uri,
    body = body,
    method = method
)

fun Entity.Leg.map() = FlightData.Leg(
    id = id,
    segmentIds = segmentIds,
    originStation = originStation,
    destinationStation = destinationStation,
    departure = departure,
    arrival = arrival,
    duration = duration,
    journeyMode = journeyMode,
    stops = stops,
    carriers = carriers,
    operatingCarriers = operatingCarriers,
    directionality = directionality,
    flightNumber = flightNumbers.map { it.map() }
)

fun Entity.FlightNumber.map() = FlightData.FlightNumber(
    flightNumber = flightNumber,
    carrierId = carrierId
)

fun Entity.Segment.map() = FlightData.Segment(
    id = id,
    originStation = originStation,
    destinationStation = destinationStation,
    departureDateTime = departureDateTime,
    operatingCarrier = operatingCarrier,
    arrivalDateTime = arrivalDateTime,
    carrier = carrier,
    duration = duration,
    flightNumber = flightNumber,
    journeyMode = journeyMode,
    directionality = directionality
)

fun Entity.Carrier.map() = FlightData.Carrier(
    id = id,
    code = code,
    name = name,
    imageUrl = imageUrl,
    displayCode = displayCode
)

fun Entity.Agent.map() = FlightData.Agent(
    id = id,
    name = name,
    imageUrl = imageUrl,
    status = status,
    optimisedForMobile = optimisedForMobile,
    bookingNumber = bookingNumber,
    type = type
)

fun Entity.Place.map() = FlightData.Place(
    id = id,
    parentId = parentId,
    code = code,
    type = type,
    name = name
)

fun Entity.Currency.map() = FlightData.Currency(
    code = code,
    symbol = symbol,
    thousandsSeparator = thousandsSeparator,
    decimalSeparator = decimalSeparator,
    symbolOnLeft = symbolOnLeft,
    spaceBetweenAmountAndSymbol = spaceBetweenAmountAndSymbol,
    roundingCoefficient = roundingCoefficient,
    decimalDigits = decimalDigits
)