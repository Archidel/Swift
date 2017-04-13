package by.epam.swift.bean;

import java.io.Serializable;

/**
 * @author Archangel
 *
 */
public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idMessage;
	private int idUser;
	private String title;
	private String description;
	
	public Message() {}
	/**
	 * @return idMessage
	 */
	public int getIdMessage() {
		return idMessage;
	}
	/** set  idMessage
	 * @param idMessage
	 */
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}
	/**
	 * @return idUser
	 */
	public int getIdUser() {
		return idUser;
	}
	/** set idUser 
	 * @param idUser
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + idMessage;
		result = prime * result + idUser;
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
		Message other = (Message) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idMessage != other.idMessage)
			return false;
		if (idUser != other.idUser)
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
		return "Message [idMessage=" + idMessage + ", idUser=" + idUser + ", title=" + title + ", description="
				+ description + "]";
	}
	
}
