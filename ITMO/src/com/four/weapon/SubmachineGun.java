package com.four.weapon;

public class SubmachineGun {

	public String name;
	public double range;
	public int rate;
	public int arms = 2;
	public int clazz = 3;
	public int id;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setRange(double range) {
		this.range = range;
	}
	public double getRange() {
		return range;
	}
	
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getRate() {
		return rate;
	}
	public int getClazz() {
		return clazz;
	}
}
