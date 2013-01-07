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

package net.bluwings.wicket.contactmanager.entities.testdata;

import javax.persistence.EntityManager;

import net.bluwings.wicket.contactmanager.entities.Address;
import net.bluwings.wicket.contactmanager.entities.AddressType;
import net.bluwings.wicket.contactmanager.entities.Person;
import de.akquinet.jbosscc.needle.db.testdata.AbstractTestdataBuilder;

public class AddressTestdataBuilder extends AbstractTestdataBuilder<Address> {

	private static final AddressType ADDRESSTYPE = AddressType.OTHER;

	private String address;
	private String city;
	private String postalCode;
	private Person person;
	private AddressType addressType;

	public AddressTestdataBuilder() {
		super();
	}

	public AddressTestdataBuilder(EntityManager entityManager) {
		super(entityManager);
	}

	public AddressTestdataBuilder address(String address) {
		this.address = address;
		return this;
	}

	public AddressTestdataBuilder city(String city) {
		this.city = city;
		return this;
	}

	public AddressTestdataBuilder postalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public AddressTestdataBuilder person(Person person) {
		this.person = person;
		return this;
	}

	public AddressTestdataBuilder addressType(AddressType addressType) {
		this.addressType = addressType;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public Person getPerson() {
		if (person != null) {
			return person;
		}
		return hasEntityManager() ? new PersonTestdataBuilder(
				getEntityManager()).buildAndSave()
				: new PersonTestdataBuilder().build();
	}

	public AddressType getAddressType() {
		return addressType != null ? addressType : ADDRESSTYPE;
	}

	@Override
	public Address build() {
		final Address address = new Address();
		address.setAddress(getAddress());
		address.setCity(getCity());
		address.setPostcode(getPostalCode());
		address.setPerson(getPerson());
		address.setAddressType(getAddressType());
		return address;
	}

}
