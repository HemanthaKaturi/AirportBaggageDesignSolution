package com.airport.baggage.dao.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.airport.baggage.dao.SectionsDao;
import com.airport.baggage.util.Constants;

public class SectionsDaoImpl implements SectionsDao {

	public final Map<String, Integer> sections;
	private String currentSection = Constants.NOSECTION;

	public SectionsDaoImpl() {
		sections = new HashMap<>();
		sections.put(Constants.CONNECTIONS, Constants.CONNECTIONS_INPUT_LENGTH);
		sections.put(Constants.DEPARTURES, Constants.DEPARTURES_INPUT_LENGTH);
		sections.put(Constants.BAGS, Constants.BAGS_INPUT_LENGTH);
	}

	public Set<String> getSectionNames() {
		return sections.keySet();
	}

	public String getCurrentSection() {
		return currentSection;
	}

	public void setCurrentSection(String currentSection) {
		this.currentSection = currentSection;
	}

}
