package com.bridgelab;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystem {
	ArrayList<Hotel> hotels = new ArrayList<Hotel>();

	public void addHotel() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Hotel Name \t: ");
		String hotelName = sc.nextLine();
		System.out.print("Enter Rating : \t");
		int hotelRating = sc.nextInt();
		System.out.print("Weekday Rate : \t");
		int weekdayRate = sc.nextInt();
		System.out.print("Weekend Rate : \t");
		int weekendRate = sc.nextInt();

		hotels.add(new Hotel(hotelName, new Integer[] { weekdayRate, weekendRate }, hotelRating));
		System.out.println("Hotel added successfully..!");
	}

	public void findCheapestBestRated() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter date range.\nEnter Start Date : ");
		String startDate = sc.nextLine();
		System.out.print("Enter End Date : ");
		String endDate = sc.nextLine();
		System.out.println("Do you want best rated hotel based on : \n1.Weekday rate\n2.Weekend rate");
		System.out.println("Enter choice ");
		int choice;
		choice = sc.nextInt();

		int min = hotels.get(0).getRate()[choice - 1];
		int ratingIndex = 0;
		for (int i = 1; i < hotels.size(); i++) {
			min = Math.min(min, hotels.get(i).getRate()[choice - 1]);
			if (hotels.get(i).getRate()[choice - 1] == min)
				ratingIndex = i;
		}
		System.out.println("Best Cheapest Rated Hotel : " + hotels.get(ratingIndex).getNameOfHotel());
		System.out.println("Rating              : " + hotels.get(ratingIndex).getRating());
		System.out.println("Rate                : " + hotels.get(ratingIndex).getRate()[choice - 1]);

	}

	public void showHotels() {
		System.out.println("Hotels ->");
		System.out.printf("%-20s%-20s%-20s%-20s\n", "Name of hotel", "Rating", "WeekdayRate", "WeekendRate");
		for (int i = 0; i < hotels.size(); i++) {
			System.out.printf("%-20s%-20d%-20d%-20d\n", hotels.get(i).getNameOfHotel(), hotels.get(i).getRating(),
					hotels.get(i).getRate()[0], hotels.get(i).getRate()[1]);
		}
	}

	public static void main(String[] args) {
		System.out.println("<<< Welcome to Hotel Reservation System >>>");
		HotelReservationSystem h = new HotelReservationSystem();
		Scanner sc = new Scanner(System.in);

		int choice;
		while (true) {
			System.out.println("1. Add a New Hotel.");
			System.out.println("2. Show Available Hotels.");
			System.out.println("3. Find Cheapest Available Hotels.");
			System.out.println("4. Exit From Hotel Reservation System.");
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
				h.findCheapestBestRated();
				break;
			case 4:
				return;
			default:
				System.out.println("Wrong choice.");
			}
		}
	}
}