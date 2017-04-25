package by.epam.swift.bean;

import java.io.Serializable;
import java.util.Date;

/** This class is designed to store information about the request on service from user.
 * @author Archangel
 *
 */
public class RequestOnService implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idRequest;
	private int idAgreement;
	private int idTariff;
	private boolean status;
	private boolean serviceAction;
	private Date date;
	
	public RequestOnService() {}

	/**
	 * @returnidRequest
	 */
	public int getIdRequest() {
		return idRequest;
	}
	/** set idRequest
	 * @param idRequest
	 */
	public void setIdRequest(int idRequest) {
		this.idRequest = idRequest;
	}
	/**
	 * @returnidAgreement
	 */
	public int getIdAgreement() {
		return idAgreement;
	}
	/** set idAgreement
	 * @param idAgreement
	 */
	public void setIdAgreement(int idAgreement) {
		this.idAgreement = idAgreement;
	}
	/**
	 * @return idTariff
	 */
	public int getIdTariff() {
		return idTariff;
	}
	/** set idTariff
	 * @param idTariff
	 */
	public void setIdTariff(int idTariff) {
		this.idTariff = idTariff;
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
	/** 
	 * @return serviceAction
	 */
	public boolean isServiceAction() {
		return serviceAction;
	}
	/** set serviceAction
	 * @param serviceAction
	 */
	public void setServiceAction(boolean serviceAction) {
		this.serviceAction = serviceAction;
	}
	/**
	 * @return date
	 */
	public Date getDate() {
		return date;
	}
	/** set date
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + idAgreement;
		result = prime * result + idRequest;
		result = prime * result + idTariff;
		result = prime * result + (serviceAction ? 1231 : 1237);
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
		RequestOnService other = (RequestOnService) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (idAgreement != other.idAgreement)
			return false;
		if (idRequest != other.idRequest)
			return false;
		if (idTariff != other.idTariff)
			return false;
		if (serviceAction != other.serviceAction)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RequestOnService [idRequest=" + idRequest + ", idAgreement=" + idAgreement + ", idTariff=" + idTariff
				+ ", status=" + status + ", serviceAction=" + serviceAction + ", date=" + date + "]";
	}

	

}
