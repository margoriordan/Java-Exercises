package edu.cscc.OrderApi.model;

public class Order {
	public long id;
	public String firstName;
	public String lastName;
	public int quantity;
	public double price;
	
	public Order(long nextId, String firstName, String lastName, int quantity, double price) {
		this.id = nextId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.quantity = quantity;
		this.price = price;
	}

}
