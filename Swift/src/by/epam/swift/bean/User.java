package by.epam.swift.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**This class is designed to store information about the user.
 * @author Archangel
 *
 */
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String surname;
	private String login;
	private int password;
	private String email;
	private String birthdate;
	private String passport;
	private String phone;
	private String address;
	private String position;
	private double balance;
	private boolean status;
	private Date blockedTill;
	private List<Tariff> list;
 
	public User() {}

	/**set id user
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id 
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/** set name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return surname
	 */
	public String getSurname() {
		return surname;
	}
	/** set surname
	 * @param surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return login
	 */
	public String getLogin() {
		return login;
	}
	/** set login
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return password
	 */
	public int getPassword() {
		return password;
	}
	/** set password
	 * @param password
	 */
	public void setPassword(int password) {
		this.password = password;
	}
	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**set email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return birthdate
	 */
	public String getBirthdate() {
		return birthdate;
	}
	/** set birthdate
	 * @param birthdate
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	/**
	 * @return passport
	 */
	public String getPassport() {
		return passport;
	}
	/** set passport
	 * @param passport
	 */
	public void setPassport(String passport) {
		this.passport = passport;
	}
	/**
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}
	/** set phone
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/** set address
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return position
	 */
	public String getPosition() {
		return position;
	}
	/** set position
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}
	/** set balance
	 * @param balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
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
	 * @return blockedTill
	 */
	public Date getBlockedTill() {
		return blockedTill;
	}
	/** set blockedTill
	 * @param blockedTill
	 */
	public void setBlockedTill(Date blockedTill) {
		this.blockedTill = blockedTill;
	}
	/**
	 * @return list
	 */
	public List<Tariff> getList() {
		return list;
	}
	/** set list
	 * @param list
	 */
	public void setList(List<Tariff> list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result + ((blockedTill == null) ? 0 : blockedTill.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((passport == null) ? 0 : passport.hashCode());
		result = prime * result + password;
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (blockedTill == null) {
			if (other.blockedTill != null)
				return false;
		} else if (!blockedTill.equals(other.blockedTill))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (passport == null) {
			if (other.passport != null)
				return false;
		} else if (!passport.equals(other.passport))
			return false;
		if (password != other.password)
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (status != other.status)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", login=" + login + ", password="
				+ password + ", email=" + email + ", birthdate=" + birthdate + ", passport=" + passport + ", phone="
				+ phone + ", address=" + address + ", position=" + position + ", balance=" + balance + ", status="
				+ status + ", blockedTill=" + blockedTill + ", list=" + list + "]";
	}

}
