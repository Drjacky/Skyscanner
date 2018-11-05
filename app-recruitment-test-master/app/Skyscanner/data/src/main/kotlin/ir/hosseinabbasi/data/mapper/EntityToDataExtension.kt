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
    status = status
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
    groupPricing = groupPricing,
    queryLocalId = queryLocalId
)

fun Entity.Itinerary.map() = FlightData.Itinerary(
    outboundLegId = outboundLegId,
    inboundLegId = inboundLegId,
    //pricingOptions = pricingOptions.map { it.map() },
    //bookingDetailsLink = bookingDetailsLink.map(),
    itineraryLocalId = itineraryLocalId,
    flightLocalId = flightId
)

fun Entity.PricingOption.map() = FlightData.PricingOption(
    agents = agents,
    deepLinkUrl = deepLinkUrl,
    price = price,
    quoteAgeInMinutes = quoteAgeInMinutes,
    pricingOptionLocalId = pricingOptionLocalId,
    itineraryLocalId = itineraryId
)

fun Entity.BookingDetailsLink.map() = FlightData.BookingDetailsLink(
    uri = uri,
    body = body,
    method = method,
    bookingDetailsLinkLocalId = bookingDetailsLinkLocalId,
    itineraryLocalId = itineraryId
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
    //flightNumbers = flightNumbers.map { it.map() },
    legLocalId = legLocalId,
    flightLocalId = flightId
)

fun Entity.FlightNumber.map() = FlightData.FlightNumber(
    flightNumber = flightNumber,
    carrierId = carrierId,
    flightNumberLocalId = flightNumberLocalId,
    legLocalId = legId
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
    directionality = directionality,
    segmentLocalId = segmentLocalId,
    flightLocalId = flightId
)

fun Entity.Carrier.map() = FlightData.Carrier(
    id = id,
    code = code,
    name = name,
    imageUrl = imageUrl,
    displayCode = displayCode,
    carrierLocalId = carrierLocalId,
    flightLocalId = flightId
)

fun Entity.Agent.map() = FlightData.Agent(
    id = id,
    name = name,
    imageUrl = imageUrl,
    status = status,
    optimisedForMobile = optimisedForMobile,
    bookingNumber = bookingNumber,
    type = type,
    agentLocalId = agentLocalId,
    flightLocalId = flightId
)

fun Entity.Place.map() = FlightData.Place(
    id = id,
    parentId = parentId,
    code = code,
    type = type,
    name = name,
    placeLocalId = placeLocalId,
    flightLocalId = flightId
)

fun Entity.Currency.map() = FlightData.Currency(
    code = code,
    symbol = symbol,
    thousandsSeparator = thousandsSeparator,
    decimalSeparator = decimalSeparator,
    symbolOnLeft = symbolOnLeft,
    spaceBetweenAmountAndSymbol = spaceBetweenAmountAndSymbol,
    roundingCoefficient = roundingCoefficient,
    decimalDigits = decimalDigits,
    currencyLocalId = currencyLocalId,
    flightLocalId = flightId
)