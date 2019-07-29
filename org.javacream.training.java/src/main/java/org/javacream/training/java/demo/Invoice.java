package org.javacream.training.java.demo;

import java.util.Date;

public class Invoice {

	private long invoiceId;
	public double totalPrice;
	private String description;
	private Date invoiceDate;

	public Invoice(long invoiceId, double totalPrice, Date invoiceDate) {
		super();
		this.invoiceId = invoiceId;
		this.totalPrice = totalPrice;
		this.invoiceDate = invoiceDate;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", totalPrice=" + totalPrice + ", description=" + description
				+ ", invoiceDate=" + invoiceDate + "]";
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getInvoiceId() {
		return invoiceId;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

}
