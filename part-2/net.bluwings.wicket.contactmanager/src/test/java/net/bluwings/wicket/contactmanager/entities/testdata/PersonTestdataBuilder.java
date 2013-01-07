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

import net.bluwings.wicket.contactmanager.entities.Gender;
import net.bluwings.wicket.contactmanager.entities.Person;

import de.akquinet.jbosscc.needle.db.testdata.AbstractTestdataBuilder;

public class PersonTestdataBuilder extends AbstractTestdataBuilder<Person> {

	private static final String FIRSTNAME = "John";
	private static final String LASTNAME = "Doe";

	private Gender gender;
	private String firstName;
	private String lastName;

	public PersonTestdataBuilder() {
		super();
	}

	public PersonTestdataBuilder(EntityManager entityManager) {
		super(entityManager);
	}

	public PersonTestdataBuilder gender(Gender gender) {
		this.gender = gender;
		return this;
	}

	public PersonTestdataBuilder firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public PersonTestdataBuilder lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	private Gender getGender() {
		return gender != null ? gender : Gender.MALE;
	}

	private String getFirstName() {
		return firstName != null ? firstName : FIRSTNAME;
	}

	private String getLastName() {
		return lastName != null ? lastName : LASTNAME;
	}

	@Override
	public Person build() {
		final Person person = new Person();
		person.setGender(getGender());
		person.setFirstName(getFirstName());
		person.setLastName(getLastName());
		return person;
	}

}
