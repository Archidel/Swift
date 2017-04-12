package by.epam.swift.bean;

import java.io.Serializable;
import java.util.Date;

public class Agreement implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idAgreement;
	private int idUser;
	private int idAdmin;
	private Date dateCreation;
	private boolean status;
	
	public Agreement() {}
	
	public int getIdAgreement() {
		return idAgreement;
	}
	public void setIdAgreement(int id) {
		this.idAgreement = id;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + idAgreement;
		result = prime * result + idAdmin;
		result = prime * result + idUser;
		result = prime * result + (status ? 1231 : 1237);
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
		Agreement other = (Agreement) obj;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (idAgreement != other.idAgreement)
			return false;
		if (idAdmin != other.idAdmin)
			return false;
		if (idUser != other.idUser)
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Agreement [id=" + idAgreement + ", idUser=" + idUser + ", idAdmin=" + idAdmin + ", dateCreation=" + dateCreation
				+ ", status=" + status + "]";
	}
	
}
