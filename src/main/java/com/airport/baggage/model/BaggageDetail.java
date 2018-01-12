package com.airport.baggage.model;

import java.util.LinkedList;
import java.util.List;

/*
 * Class to represent Baggage details
 */
public class BaggageDetail {

	public final String bagNumber;
	public final String departureGate;
	public final String arrivalGate;
	private LinkedList<String> connections;
	private boolean pathFound;
	private int travelTime;

	public BaggageDetail(final String bagNumber, final String departureGate, final String arrivalGate) {
		this.bagNumber = bagNumber;
		this.departureGate = departureGate;
		this.arrivalGate = arrivalGate;
		this.connections = new LinkedList<>();
	}
	
	public void updateConnections(List<String> connectionsFound) {
		this.connections.addAll(connectionsFound);
		this.pathFound = true;
	}
	
	@SuppressWarnings("unchecked")
	public List<String>  cloneConnections() {
		return  (LinkedList<String>) connections.clone();
	}
	
	public int updateTravelTime(int travelTime) {
		this.travelTime += travelTime;
		return this.travelTime;
	}

	/**
	 * Build Baggage details as String
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(bagNumber);
		connections.forEach(gate -> builder.append(" " + gate));
		builder.append(" : " + travelTime);
		return builder.toString();
	}

	public boolean isPathFound() {
		return this.pathFound;
	}

}