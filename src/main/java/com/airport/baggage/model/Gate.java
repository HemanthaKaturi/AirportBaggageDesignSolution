package com.airport.baggage.model;

/*
 * Class to represent Gates
 *
 */
public class Gate {

	public final String name;
	public final int travelTime;

	public Gate(String gate, int travelTime) {
		this.name = gate;
		this.travelTime = travelTime;
	}

}