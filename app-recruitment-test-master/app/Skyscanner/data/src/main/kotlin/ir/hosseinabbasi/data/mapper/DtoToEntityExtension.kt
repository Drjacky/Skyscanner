package ir.hosseinabbasi.data.mapper

import ir.hosseinabbasi.data.api.FlightApi
import ir.hosseinabbasi.domain.entity.Entity

/**
 * Created by Dr.jacky on 11/4/2018.
 */
/**
 * Extension class to map album dto to album entity
 */
fun FlightApi.Dto.Flight.map() = Entity.Flight(
    flightLocalId = null,
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

fun FlightApi.Dto.Query.map() = Entity.Query(
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
    groupPricing = groupPricing,
    queryLocalId = null
)

fun FlightApi.Dto.Itinerary.map() = Entity.Itinerary(
    outboundLegId = outboundLegId,
    inboundLegId = inboundLegId,
    pricingOptions = pricingOptions.map { it.map() },
    bookingDetailsLink = bookingDetailsLink.map(),
    itineraryLocalId = null,
    flightId = null
)

fun FlightApi.Dto.PricingOption.map() = Entity.PricingOption(
    agents = agents,
    deepLinkUrl = deepLinkUrl,
    price = price,
    quoteAgeInMinutes = quoteAgeInMinutes,
    pricingOptionLocalId = null,
    itineraryId = null
)

fun FlightApi.Dto.BookingDetailsLink.map() = Entity.BookingDetailsLink(
    uri = uri,
    body = body,
    method = method,
    bookingDetailsLinkLocalId = null,
    itineraryId = null
)

fun FlightApi.Dto.Leg.map() = Entity.Leg(
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
    flightNumbers = flightNumbers.map { it.map() },
    legLocalId = null,
    flightId = null
)

fun FlightApi.Dto.FlightNumber.map() = Entity.FlightNumber(
    flightNumber = flightNumber,
    carrierId = carrierId,
    flightNumberLocalId = null,
    legId = null
)

fun FlightApi.Dto.Segment.map() = Entity.Segment(
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
    directionality = directionality,
    segmentLocalId = null,
    flightId = null
)

fun FlightApi.Dto.Carrier.map() = Entity.Carrier(
    id = id,
    code = code,
    name = name,
    imageUrl = imageUrl,
    displayCode = displayCode,
    carrierLocalId = null,
    flightId = null
)

fun FlightApi.Dto.Agent.map() = Entity.Agent(
    id = id,
    name = name,
    imageUrl = imageUrl,
    status = status,
    optimisedForMobile = optimisedForMobile,
    bookingNumber = bookingNumber,
    type = type,
    agentLocalId = null,
    flightId = null
)

fun FlightApi.Dto.Place.map() = Entity.Place(
    id = id,
    parentId = parentId,
    code = code,
    type = type,
    name = name,
    placeLocalId = null,
    flightId = null
)

fun FlightApi.Dto.Currency.map() = Entity.Currency(
    code = code,
    symbol = symbol,
    thousandsSeparator = thousandsSeparator,
    decimalSeparator = decimalSeparator,
    symbolOnLeft = symbolOnLeft,
    spaceBetweenAmountAndSymbol = spaceBetweenAmountAndSymbol,
    roundingCoefficient = roundingCoefficient,
    decimalDigits = decimalDigits,
    currencyLocalId = null,
    flightId = null
)