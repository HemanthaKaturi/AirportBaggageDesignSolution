package com.airport.baggage.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.airport.baggage.util.Constants;

public class ValidationServiceImpl implements ValidationService{
	private static Logger logger = Logger.getLogger(ValidationServiceImpl.class.getName());

	public ValidationServiceImpl(Level logLevel) {
		logger.setLevel(logLevel);
	}

	private List<String> exceptions = new LinkedList<>();

	/**
	 * include errormessage in exception list
	 * 
	 * @param errMsg
	 */
	public void addExceptionDetail(String errMsg) {
		if (errMsg != null && !errMsg.trim().isEmpty()) {
			getExceptions().add(errMsg);
		}
	}

	/**
	 * 
	 * @param inputString
	 * @return
	 */
	public boolean isSection(final String inputString) {
		return (inputString.toLowerCase().startsWith(Constants.SECTION));
	}

	/**
	 * 
	 * @param currentSection
	 * @param inputString
	 * @param sections
	 * @return
	 */
	public String validateSection(String currentSection, String inputString, final Set<String> sections) {
		final String tempValue = inputString.toLowerCase().replaceFirst(Constants.SECTION, "").trim();
		Optional<String> section = sections.stream().filter(value -> value.equalsIgnoreCase(tempValue)).findFirst();
		if (section.isPresent()) {
			return section.get();
		}
		addExceptionDetail(Constants.NOSECTION + "/Invalid section entered [" + inputString + "] to process Data;");
		return null;
	}

	/**
	 * 
	 * @param values
	 * @return
	 */
	public boolean validateConnection(final List<String> values) {
		if (values.size() == Constants.CONNECTIONS_INPUT_LENGTH && !values.get(0).equalsIgnoreCase(values.get(1))) {
			String integerString = values.get(values.size()-1);
			try {
				int value = Integer.parseInt(integerString);
				return value>0;
			} catch (NumberFormatException numEx) {
				addExceptionDetail("Invalid int value [" + integerString + "]");
			}
			return false;
		}
		String errMsg = "Invalid inputs For " + Constants.CONNECTIONS + " ; ";
		if(values.size()>1 && values.get(0).equalsIgnoreCase(values.get(1))){
			errMsg += " Departure and Arrival gates ["+values.get(0)+"] cannot be same;";
		}else {
			errMsg += " Only " + Constants.CONNECTIONS_INPUT_LENGTH +" values; "
						+values+"  of [String, String, int] are accepted;";
		}
		addExceptionDetail(errMsg);
		return false;
	}

	/**
	 * 
	 * @param values
	 * @return
	 */
	public boolean validateDeparture(final List<String>  values) {
		if (values.size() == Constants.DEPARTURES_INPUT_LENGTH) {
			return true;
		}
		addExceptionDetail("Invalid inputs for " + Constants.DEPARTURES + " ; Only "
				+ Constants.DEPARTURES_INPUT_LENGTH + " values; "+values+" of [String, String, String, hh:mm] are accepted;");
		return false;
	}

	/**
	 * 
	 * @param values
	 * @return
	 */
	public boolean validateBaggageGates(final List<String> values) {
		if (values.size() == Constants.BAGS_INPUT_LENGTH ) {
			return true;
		}
		addExceptionDetail("Invalid inputs; for " + Constants.BAGS + " Section only " + Constants.BAGS_INPUT_LENGTH
				+ " string values are accepted;"+values);
		return false;
	}
	
	public boolean validateBaggageDestination(final List<String> values) {
		if(values.get(1).equalsIgnoreCase(values.get(2))){
			addExceptionDetail("Invalid inputs; for " + Constants.BAGS + " Section ;Arrival gate & Departure flight gate [" +values.get(1)+"] cannot be same;");
			return false;
		}
		return true;
	}

	
	public void addDuplicateFlightException(final List<String> values) {
		addExceptionDetail("FlightId["+values.get(0)+"] already Exists; Cannot insert data for  "+Constants.DEPARTURES+" ; "+values);
	}
	
	public List<String> getExceptions() {
		return exceptions;
	}

}
