package com.tnas.assignment.statistics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class USCrimeManager {

	private static final String LINE_SEPARATOR = ",";
	private static final int DEFAULT_INVALID_OPTION = 99;
	private USCrimeStatistics crimeStatistics;
	private Path pathFile;

	private void loadUSCrimeStatistics() {

		List<USCrime> crimesList = new ArrayList<>();

		try (Stream<String> stream = Files.lines(this.pathFile).skip(1)) {
			stream.forEach(line -> {
				int position = 0;
				USCrime crime = new USCrime();
				String[] data = line.split(LINE_SEPARATOR);
				crime.setYear(new Integer(data[position++]));
				crime.setPopulation(new Long(data[position++]));
				crime.setViolentCrime(new Long(data[position++]));
				crime.setViolentCrimeRate(new Float(data[position++]));
				crime.setMurder(new Long(data[position++]));
				crime.setMurderRate(new Float(data[position++]));
				crime.setRape(new Long(data[position++]));
				crime.setRapeRate(new Float(data[position++]));
				crime.setRobbery(new Long(data[position++]));
				crime.setRobberyRate(new Float(data[position++]));
				crime.setAssault(new Long(data[position++]));
				crime.setAssaultRate(new Float(data[position++]));
				crime.setPropertyCrime(new Long(data[position++]));
				crime.setPropertyCrimeRate(new Float(data[position++]));
				crime.setBurglary(new Long(data[position++]));
				crime.setBurglaryRate(new Float(data[position++]));
				crime.setLarcenyTheft(new Long(data[position++]));
				crime.setLarcenyTheftRate(new Float(data[position++]));
				crime.setMotorVehicleTheft(new Long(data[position++]));
				crime.setMotorVehicleTheftRate(new Float(data[position]));
				crimesList.add(crime);
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

		this.crimeStatistics = new USCrimeStatistics(crimesList.toArray(new USCrime[crimesList.size()]));
	}

	private void getPathFile(Scanner scan) {
		while (true) {
			System.out.println("Please, enter the name of the US Crime Data file: ");
			String fileName = scan.next();
			this.pathFile = Paths.get(fileName);
			if (!Files.exists(pathFile)) {
				System.out.println("The file has not been found!");
			}
			else {
				break;
			}
		}
	}

	public USCrimeStatistics getCrimeStatistics() {
		return crimeStatistics;
	}

	public static void main(String[] args) {

		USCrimeManager manager = new USCrimeManager();
		Scanner scanner = new Scanner(System.in);

		Instant start = Instant.now();
		System.out.println("Welcome to US Crime Statistics Program!");
		manager.getPathFile(scanner);
		manager.loadUSCrimeStatistics();
		System.out.println("US crime data file has been successfully loaded.");
		int option;
		
		do {
			System.out.println("Enter your option: ");
			Arrays.stream(StatisticsOption.values()).forEach(opt -> {
				System.out.println(String.format("%d - %s", opt.ordinal(), opt.getDescription()));
			});

			try {
				option = scanner.nextInt();

				if (option == StatisticsOption.QUIT.ordinal()) {
					// nothing to do
				} else if (option == StatisticsOption.POPULATION_GROWTH.ordinal()) {
					manager.getCrimeStatistics().getPopulationGrouth();
				} else if (option == StatisticsOption.MIN_MURDER_RATES.ordinal()) {
					manager.getCrimeStatistics().getMinMurderYear();
				} else if (option == StatisticsOption.MAX_MURDER_RATES.ordinal()) {
					manager.getCrimeStatistics().getMaxMurderYear();
				} else if (option == StatisticsOption.MIN_ROBBERY_RATES.ordinal()) {
					manager.getCrimeStatistics().getMinRobberyYear();
				} else if (option == StatisticsOption.MAX_ROBBERY_RATES.ordinal()) {
					manager.getCrimeStatistics().getMaxRobberyYear();
				} else {
					System.out.println("The option is not available!");
				}
			} catch (Exception e) {
				System.out.println("The option is not available!");
				scanner.nextLine();
				option = DEFAULT_INVALID_OPTION;
			}
		} while (option != StatisticsOption.QUIT.ordinal());
		
		System.out.println("Thank you for trying the US Crime Statistics Program!");
		Instant end = Instant.now();

		System.out.println(String.format("Elpased Time: %d seconds.", Duration.between(start, end).getSeconds()));
		scanner.close();
	}
}
