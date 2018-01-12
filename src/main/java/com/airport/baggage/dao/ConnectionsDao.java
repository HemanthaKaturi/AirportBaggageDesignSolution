package com.airport.baggage.dao;

import java.util.List;
import java.util.Set;

import com.airport.baggage.model.Gate;

public interface ConnectionsDao {

	List<Gate> getAdjacentGates(String last);

	void addTwoWayConnection(List<String> values);

	Set<Gate> getConnections(String first);

}
