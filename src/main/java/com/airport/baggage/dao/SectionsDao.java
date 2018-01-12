package com.airport.baggage.dao;

import java.util.Set;

public interface SectionsDao {

	String getCurrentSection();

	Set<String> getSectionNames();

	void setCurrentSection(String validateSection);

}
