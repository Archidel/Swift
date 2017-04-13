package by.epam.swift.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Archangel
 *
 */
public class News implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private Date datePublication;
	private String description;
	private boolean status;

	public News() {}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/** set  id
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
	/** set  title
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return datePublication
	 */
	public Date getDatePublication() {
		return datePublication;
	}
	/** set  datePublication
	 * @param datePublication
	 */
	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
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
		result = prime * result + ((datePublication == null) ? 0 : datePublication.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		News other = (News) obj;
		if (datePublication == null) {
			if (other.datePublication != null)
				return false;
		} else if (!datePublication.equals(other.datePublication))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (status != other.status)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", datePublication=" + datePublication + ", description="
				+ description + ", status=" + status + "]";
	}

}
