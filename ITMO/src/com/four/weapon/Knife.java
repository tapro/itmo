package com.four.weapon;

public class Knife {

	public String name;
	public double range;
	public int arms = 1;
	int clazz = 1;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public int getClazz() {
		return clazz;
	}
	
	public void setRange(double range) {
		this.range = range;
	}
	public double getRange() {
		return range;
	}

}
