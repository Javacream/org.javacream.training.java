package org.javacream.training.java.publishing.api.types;

public class Order {

	private long orderId;
	private String isbn;
	private int number;
	private double totalPrice;
	private OrderStatus status;

	
	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	public long getOrderId() {
		return orderId;
	}


	public String getIsbn() {
		return isbn;
	}


	public int getNumber() {
		return number;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + number;
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (number != other.number)
			return false;
		if (orderId != other.orderId)
			return false;
		if (status != other.status)
			return false;
		if (Double.doubleToLongBits(totalPrice) != Double.doubleToLongBits(other.totalPrice))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", isbn=" + isbn + ", number=" + number + ", totalPrice=" + totalPrice
				+ ", status=" + status + "]";
	}


	public Order(long orderId, String isbn, int number, double totalPrice, OrderStatus status) {
		super();
		this.orderId = orderId;
		this.isbn = isbn;
		this.number = number;
		this.totalPrice = totalPrice;
		this.status = status;
	}


	public enum OrderStatus{
		OK, PENDING, UNAVAILABLE;
	}

}

