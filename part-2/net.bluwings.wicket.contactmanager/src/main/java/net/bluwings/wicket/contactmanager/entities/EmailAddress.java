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

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

/**
 * Entity implementation class for Entity: EmailAddress
 * 
 */
@Entity
public class EmailAddress implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Email
	private String address;

	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private AddressType addressType;

	@NotNull
	@ManyToOne(optional = false)
	private Person person;

	private static final long serialVersionUID = 1L;

	public EmailAddress() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
