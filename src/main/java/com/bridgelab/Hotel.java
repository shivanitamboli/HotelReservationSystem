package com.bridgelab;

import java.util.Arrays;

public class Hotel {
	private String nameOfHotel;
	private Integer[] rate;

	public Hotel(String nameOfHotel, Integer[] rate) {
		this.nameOfHotel = nameOfHotel;
		this.rate = rate;
	}

	public String getNameOfHotel() {
		return nameOfHotel;
	}

	public void setNameOfHotel(String nameOfHotel) {
		this.nameOfHotel = nameOfHotel;
	}

	public Integer[] getRate() {
		return rate;
	}

	public void setRate(Integer[] rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Hotel{" + "nameOfHotel='" + nameOfHotel + '\'' + ", rate=" + Arrays.toString(rate) + '}';
	}
}
