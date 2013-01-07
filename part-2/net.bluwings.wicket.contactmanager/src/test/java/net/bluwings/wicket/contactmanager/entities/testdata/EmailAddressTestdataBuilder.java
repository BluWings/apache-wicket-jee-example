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

import net.bluwings.wicket.contactmanager.entities.AddressType;
import net.bluwings.wicket.contactmanager.entities.EmailAddress;
import net.bluwings.wicket.contactmanager.entities.Person;
import de.akquinet.jbosscc.needle.db.testdata.AbstractTestdataBuilder;

public class EmailAddressTestdataBuilder extends
		AbstractTestdataBuilder<EmailAddress> {

	private static final AddressType ADDRESSTYPE = AddressType.OTHER;

	private String address;
	private Person person;
	private AddressType addressType;

	public EmailAddressTestdataBuilder() {
		super();
	}

	public EmailAddressTestdataBuilder(EntityManager entityManager) {
		super(entityManager);
	}

	public EmailAddressTestdataBuilder address(String address) {
		this.address = address;
		return this;
	}

	public EmailAddressTestdataBuilder person(Person person) {
		this.person = person;
		return this;
	}

	public EmailAddressTestdataBuilder addressType(AddressType addressType) {
		this.addressType = addressType;
		return this;
	}

	public String getAddress() {
		return this.address;
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
	public EmailAddress build() {
		EmailAddress emailAddress = new EmailAddress();
		emailAddress.setAddress(getAddress());
		emailAddress.setPerson(getPerson());
		emailAddress.setAddressType(getAddressType());
		return emailAddress;
	}
}
