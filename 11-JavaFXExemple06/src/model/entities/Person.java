package model.entities;

import java.io.Serializable;

public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer ID;
	private String name;
	private String mail;
	
	public Person(){	
	}

	public Person(Integer iD, String name, String mail) {
		ID = iD;
		this.name = name;
		this.mail = mail;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Person [ID=" + ID + ", name=" + name + ", mail=" + mail + "]";
	}
	
}
