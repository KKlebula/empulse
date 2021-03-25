package de.KKlebula.Aufgabe1;

public class Article
{
	private String name;
	private int group;
	private double price;
	
	public Article(String name, int group, double price) {
		this.name = name;
		this.group = group;
		this.price = price;
	}

	public String getName(){
		return this.name;
	}
	
	public void setName(String newName) 
	{
		this.name = newName;
	}
	
	public int getGroup(){
		return this.group;
	}
	
	public void setGroup(int newGroup) {
		this.group = newGroup;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public void setPrice(double newPrice) {
		this.price = newPrice;
	}
}

