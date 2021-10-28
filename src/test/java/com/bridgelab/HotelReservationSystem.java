package com.bridgelab;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystem {
	ArrayList<Hotel> hotels = new ArrayList<Hotel>();

	public void addHotel() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Hotel Name \t: ");
		String hotelName = sc.nextLine();
		System.out.print("Enter Rate : \t");
		int hotelRate = sc.nextInt();

		hotels.add(new Hotel(hotelName, hotelRate));
		System.out.println("Hotel added successfully..!");
	}

	public void findCheapest() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter date range.\nEnter Start Date : ");
		String startDate = sc.nextLine();
		System.out.print("Enter End Date : ");
		String endDate = sc.nextLine();
		int min = hotels.get(0).getRate();
		int ratingIndex = 0;
		for (int i = 1; i < hotels.size(); i++) {
			min = Math.min(min, hotels.get(i).getRate());
			if (hotels.get(i).getRate() == min)
				ratingIndex = i;
		}
		System.out.println("Best Cheapest Hotel : " + hotels.get(ratingIndex).getNameOfHotel());
		System.out.println("Rate           : " + hotels.get(ratingIndex).getRate());
	}

	public void showHotels() {
		System.out.println("Hotels ->");
		System.out.printf("%-20s%-20s\n", "Name of hotel", "Rate");
		for (int i = 0; i < hotels.size(); i++) {
			System.out.printf("%-20s%-20d\n", hotels.get(i).getNameOfHotel(), hotels.get(i).getRate());
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
				h.findCheapest();
				break;
			case 4:
				return;
			default:
				System.out.println("Wrong choice.");
			}
		}
	}
}