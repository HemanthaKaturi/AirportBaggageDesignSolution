package com.airport.baggage.dao.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.airport.baggage.dao.BaggageDao;
import com.airport.baggage.model.BaggageDetail;

public class BaggageDaoImpl implements BaggageDao {
	private static Logger logger = Logger.getLogger(BaggageDaoImpl.class.getName());

	public BaggageDaoImpl(Level logLevel) {
		logger.setLevel(logLevel);
	}

	private List<BaggageDetail> baggageList = new LinkedList<>();

	public List<BaggageDetail> getBaggageList() {
		return baggageList;
	}

	/**
	 * Add baggage details to the Linked list to maintain insertion order
	 * 
	 * @param bagNumber
	 * @param departureGate
	 * @param arrivalGate
	 */
	public void addBaggageDetail(final String bagNumber, final String departureGate, final String arrivalGate) {
		getBaggageList().add(new BaggageDetail(bagNumber, departureGate, arrivalGate));
		if(logger.isLoggable(Level.FINE))
		logger.log(Level.FINE, "BaggageDetail added for bagNumber[" + bagNumber + "] departureGate[" + departureGate + "] arrivalGate[" + arrivalGate + "]");
	}

}
