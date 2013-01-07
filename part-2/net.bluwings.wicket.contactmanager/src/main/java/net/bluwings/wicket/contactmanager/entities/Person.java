/*******************************************************************************
 * Copyright (c) 2012 SMB GmbH, Dresden - Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SMB GmbH - initial API and implementation
 *******************************************************************************/

package net.bluwings.wicket.contactmanager.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Person
 * 
 */
@Entity
public class Person implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Enumerated(EnumType.ORDINAL)
	private Gender gender;

	private String firstName;

	private String lastName;

	private Date dateOfBirth = new Date();

	private String jobTitle;

	@OneToMany(mappedBy = "person", cascade = { CascadeType.REMOVE,
			CascadeType.REFRESH })
	private List<EmailAddress> emailAddresses = new ArrayList<EmailAddress>();

	@OneToMany(mappedBy = "person", cascade = { CascadeType.REMOVE,
			CascadeType.REFRESH })
	private List<Address> addresses = new ArrayList<Address>();

	@OneToMany(mappedBy = "person", cascade = { CascadeType.REMOVE,
			CascadeType.REFRESH })
	private List<Telephone> telephones = new ArrayList<Telephone>();

	private static final long serialVersionUID = 1L;

	public Person() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public List<EmailAddress> getEmailAddresses() {
		return Collections.unmodifiableList(emailAddresses);
	}

	public void addEmailAddress(EmailAddress emailAddress) {
		emailAddresses.add(emailAddress);
	}

	public boolean removeEmailAddress(EmailAddress emailAddress) {
		return emailAddresses.remove(emailAddress);
	}

	public List<Address> getAddresses() {
		return Collections.unmodifiableList(addresses);
	}

	public void addAddress(Address address) {
		addresses.add(address);
	}

	public boolean removeAddress(Address address) {
		return addresses.remove(address);
	}

	public List<Telephone> getTelephones() {
		return Collections.unmodifiableList(telephones);
	}

	public void addTelephone(Telephone telephone) {
		telephones.add(telephone);
	}

	public boolean removeTelephone(Telephone telephone) {
		return telephones.remove(telephone);
	}

}
