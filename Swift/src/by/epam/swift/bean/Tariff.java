package by.epam.swift.bean;

import java.io.Serializable;

/**This class is designed to store information about the tariff.
 * @author Archangel
 *
 */
public class Tariff implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String type;
	private double price;
	private String description;
	private boolean status;
	
	public Tariff() {}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/** set id tariff
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/** set title
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}
	/**set type
	 * @param type 
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	/** set price
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	/** set description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return status
	 */
	public boolean isStatus() {
		return status;
	}
	/** set status
	 * @param status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Tariff other = (Tariff) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (status != other.status)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tariff [id=" + id + ", title=" + title + ", type=" + type + ", price=" + price + ", description="
				+ description + ", status=" + status + "]";
	}

}
