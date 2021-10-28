package com.bridgelab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HotelReservationSystem {
	ArrayList<Hotel> hotels = new ArrayList<Hotel>();

	public void addHotel() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Hotel Name \t: ");
		String hotelName = sc.nextLine();
		System.out.print("Enter Rating : \t");
		int hotelRating = sc.nextInt();
		System.out.print("Enter Hotel Rate \n");
		System.out.print("Weekday Rate : \t");
		int weekdayRate = sc.nextInt();
		System.out.print("Weekend Rate : \t");
		int weekendRate = sc.nextInt();
		System.out.print("Special Rate : \t");
		int specialRate = sc.nextInt();

		hotels.add(new Hotel(hotelName, new Integer[] { weekdayRate, weekendRate, specialRate }, hotelRating));
		System.out.println("Hotel added successfully..!");
	}

	public void showHotels() {
		System.out.println("Hotels ->");
		System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "Name of hotel", "Rating", "Weekday Rate", "Weekend Rate",
				"Special Rate");
		for (int i = 0; i < hotels.size(); i++) {
			System.out.printf("%-20s%-20d%-20d%-20d%-20d\n", hotels.get(i).getNameOfHotel(), hotels.get(i).getRating(),
					hotels.get(i).getRate()[0], hotels.get(i).getRate()[1], hotels.get(i).getRate()[2]);
		}
	}

	public void findCheapest() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter date range.\nEnter Start Date : ");
		String startDate = sc.nextLine();
		System.out.print("Enter End Date : ");
		String endDate = sc.nextLine();
		System.out.print("Enter Special customer name : ");
		int choice;
		choice = sc.nextInt();

		int minIndex = 0;
		try {
			int min = hotels.get(0).getRate()[0];
			for (int i = 1; i < hotels.size(); i++) {
				min = Math.min(min, hotels.get(i).getRate()[0]);
				if (hotels.get(i).getRate()[choice - 1] == min)
					minIndex = i;
			}
			System.out.println("Cheapest Hotel name : " + hotels.get(minIndex).getNameOfHotel());
			System.out.println("Rating              : " + hotels.get(minIndex).getRating());
			System.out.println("Cheapest Rate       : " + min);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid choice");
		}
	}

	public void findBestRatedHotel() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter date range.\nEnter Start Date : ");
		String startDate = sc.nextLine();
		System.out.print("Enter End Date : ");
		String endDate = sc.nextLine();
		int max = hotels.get(0).getRating();
		int ratingIndex = 0;
		for (int i = 1; i < hotels.size(); i++) {
			max = Math.max(max, hotels.get(i).getRating());
			if (hotels.get(i).getRating() == max)
				ratingIndex = i;
		}
		System.out.println("Best Rated Hotel : " + hotels.get(ratingIndex).getNameOfHotel());
		System.out.println("Rating           : " + hotels.get(ratingIndex).getRating());
	}

	public static void main(String[] args) {
		System.out.println("<<< Welcome to Hotel Reservation System >>>");
		HotelReservationSystem h = new HotelReservationSystem();
		Scanner sc = new Scanner(System.in);

		int choice;
		while (true) {
			System.out.println("1. Adding a New Hotel.");
			System.out.println("2. Show Available Hotels.");
			System.out.println("3. Find Cheapest Available Hotels.");
			System.out.println("4. Find Best Rated Available Hotels.");
			System.out.println("5. Exit From Hotel Reservation System.");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				h.addHotel();
				break;
			case 2:
				h.showHotels();
				break;
			case 3:
				h.findCheapest();
				break;
			case 4:
				h.findBestRatedHotel();
				break;
			case 5:
				return;
			default:
				System.out.println("Wrong choice.");
			}
		}
	}
}