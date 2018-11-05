package ir.hosseinabbasi.data.mapper

import ir.hosseinabbasi.data.db.flight.FlightData
import ir.hosseinabbasi.domain.entity.Entity

/**
 * Created by Dr.jacky on 11/2/2018.
 */
/**
 * Extension class to map flight data to flight entity
 */
/*fun FlightData.Flight.map() = Entity.Flight(
    sessionKey = sessionKey,
    query = query.map(),
    status = status,
    itineraries = null,//itineraries.map { it.map() },
    legs = null,//legs.map { it.map() },
    segments = null,//segments.map { it.map() },
    carriers = null,//carriers.map { it.map() },
    agents = null,//agents.map { it.map() },
    places = null,//places.map { it.map() },
    currencies = null,//currencies.map { it.map() },
    flightLocalId = flightLocalId
)*/

fun FlightData.Result.map() = Entity.Flight(
    sessionKey = flight.sessionKey,
    query = flight.query.map(),
    status = flight.status,
    itineraries = itineraries.map { it.map() },
    legs = legs.map { it.map() },
    segments = segments.map { it.map() },
    carriers = carriers.map { it.map() },
    agents = agents.map { it.map() },
    places = places.map { it.map() },
    currencies = currencies.map { it.map() },
    flightLocalId = flight.flightLocalId
)

fun FlightData.Query.map() = Entity.Query(
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
    queryLocalId = queryLocalId
)

fun FlightData.Itinerary.map() = Entity.Itinerary(
    outboundLegId = outboundLegId,
    inboundLegId = inboundLegId,
    pricingOptions = null,//pricingOptions.map { it.map() },
    bookingDetailsLink = null,//bookingDetailsLink.map(),
    itineraryLocalId = itineraryLocalId,
    flightId = flightLocalId
)

fun FlightData.PricingOption.map() = Entity.PricingOption(
    agents = agents,
    deepLinkUrl = deepLinkUrl,
    price = price,
    quoteAgeInMinutes = quoteAgeInMinutes,
    pricingOptionLocalId = pricingOptionLocalId,
    itineraryId = null
)

fun FlightData.BookingDetailsLink.map() = Entity.BookingDetailsLink(
    uri = uri,
    body = body,
    method = method,
    bookingDetailsLinkLocalId = bookingDetailsLinkLocalId,
    itineraryId = null
)

fun FlightData.Leg.map() = Entity.Leg(
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
    flightNumbers = null,//flightNumbers.map { it.map() },
    legLocalId = legLocalId,
    flightId = flightLocalId
)

fun FlightData.FlightNumber.map() = Entity.FlightNumber(
    flightNumber = flightNumber,
    carrierId = carrierId,
    flightNumberLocalId = flightNumberLocalId,
    legId = null
)

fun FlightData.Segment.map() = Entity.Segment(
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
    segmentLocalId = segmentLocalId,
    flightId = flightLocalId
)

fun FlightData.Carrier.map() = Entity.Carrier(
    id = id,
    code = code,
    name = name,
    imageUrl = imageUrl,
    displayCode = displayCode,
    carrierLocalId = carrierLocalId,
    flightId = flightLocalId
)

fun FlightData.Agent.map() = Entity.Agent(
    id = id,
    name = name,
    imageUrl = imageUrl,
    status = status,
    optimisedForMobile = optimisedForMobile,
    bookingNumber = bookingNumber,
    type = type,
    agentLocalId = agentLocalId,
    flightId = flightLocalId
)

fun FlightData.Place.map() = Entity.Place(
    id = id,
    parentId = parentId,
    code = code,
    type = type,
    name = name,
    placeLocalId = placeLocalId,
    flightId = flightLocalId
)

fun FlightData.Currency.map() = Entity.Currency(
    code = code,
    symbol = symbol,
    thousandsSeparator = thousandsSeparator,
    decimalSeparator = decimalSeparator,
    symbolOnLeft = symbolOnLeft,
    spaceBetweenAmountAndSymbol = spaceBetweenAmountAndSymbol,
    roundingCoefficient = roundingCoefficient,
    decimalDigits = decimalDigits,
    currencyLocalId = currencyLocalId,
    flightId = flightLocalId
)