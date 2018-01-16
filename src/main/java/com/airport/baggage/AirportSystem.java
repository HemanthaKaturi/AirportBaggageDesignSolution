package com.airport.baggage;

import java.util.Scanner;
import java.util.logging.Level;

import com.airport.baggage.service.BaggageService;
import com.airport.baggage.service.BaggageServiceImpl;

public class AirportSystem {

	BaggageService baggageService;

	/*
	 * Read data until EOF is reached after which search path to destination gate
	 */
	public static void main(String[] args) {

		BaggageServiceImpl baggageService = new BaggageServiceImpl(Level.OFF);
		Scanner input = null;
		String inputString = null;
		input = new Scanner(System.in);
		while (!(inputString = input.nextLine().trim()).isEmpty())
			baggageService.insertSystemData(inputString);

		System.out.println(baggageService.findBaggageRoute());
		input.close();

	}

}
