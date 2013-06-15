package com.dpbsoft.app;

public class Globals{

	private int charity;

	private int category;
	
	private static Globals instance;
	
	static {
        instance = new Globals();
    }
	
	public static Globals getInstance() {
        return Globals.instance;
    }
	
	public int getCharity(){
		return charity;
	}
	
	public void setCharity(int i){
		charity = i;
	}
	
	public int getCategory(){
		return category;
	}
	
	public void setCategory(int i){
		category = i;
	}
}
