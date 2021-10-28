package com.bridgelab;

public class Hotel {
	private String nameOfHotel;
	private int rate;

	public Hotel(String nameOfHotel, int rate) {
		this.nameOfHotel = nameOfHotel;
		this.rate = rate;
	}

	public String getNameOfHotel() {
		return nameOfHotel;
	}

	public void setNameOfHotel(String nameOfHotel) {
		this.nameOfHotel = nameOfHotel;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Hotel{" + "nameOfHotel='" + nameOfHotel + '\'' + ", rate=" + rate + '}';
	}
}
