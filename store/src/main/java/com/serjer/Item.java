package com.serjer;


import java.util.Date;

public class Item {
	private String name;
	private long code;
	private int quantity;
	private Date expiration_Date;
	
	public Item() {
		
	}
	public Item(String name, long code, int quantity, Date expiration_Date) {
		super();
		this.name = name;
		this.code = code;
		this.quantity = quantity;
		this.expiration_Date = expiration_Date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getExpiration_Date() {
		return expiration_Date;
	}
	public void setExpiration_Date(Date expiration_Date) {
		this.expiration_Date = expiration_Date;
	}
	@Override
	public String toString() {
		return String.format("name: %s, code: %s, quantity: %s, expiration date: %s", name, code, quantity,
				Store.sdf.format(expiration_Date));
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (code ^ (code >>> 32));
		result = prime * result + ((expiration_Date == null) ? 0 : expiration_Date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Item other = (Item) obj;
		if (code != other.code)
			return false;
		if (expiration_Date == null) {
			if (other.expiration_Date != null)
				return false;
		} else if (!expiration_Date.equals(other.expiration_Date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
