package com.airport.baggage.dao;

import java.util.List;

import com.airport.baggage.model.BaggageDetail;

public interface BaggageDao {

	void addBaggageDetail(String string, String string2, String arrivalGate);

	List<BaggageDetail> getBaggageList();

}
