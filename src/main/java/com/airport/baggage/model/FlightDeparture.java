package com.airport.baggage.model;

/*
 * Class to represent Flight details
 */
public class FlightDeparture {

	public final String flightId;
	public final String flightGate;
	public final String destination;
	public final String flightTime;

	public FlightDeparture(String flightId, String flightGate, String destination, String flightTime) {
		this.flightId = flightId;
		this.flightGate = flightGate;
		this.destination = destination;
		this.flightTime = flightTime;
	}

}