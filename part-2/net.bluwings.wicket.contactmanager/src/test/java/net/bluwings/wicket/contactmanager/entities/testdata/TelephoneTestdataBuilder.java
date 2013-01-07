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

import net.bluwings.wicket.contactmanager.entities.Person;
import net.bluwings.wicket.contactmanager.entities.Telephone;
import net.bluwings.wicket.contactmanager.entities.TelephoneType;
import de.akquinet.jbosscc.needle.db.testdata.AbstractTestdataBuilder;

public class TelephoneTestdataBuilder extends
		AbstractTestdataBuilder<Telephone> {

	private static final TelephoneType TELEPHONETYPE = TelephoneType.OTHER;

	private Integer countryCode;
	private Integer number;
	private Person person;
	private TelephoneType telephoneType;

	public TelephoneTestdataBuilder() {
		super();
	}

	public TelephoneTestdataBuilder(EntityManager entityManager) {
		super(entityManager);
	}

	public TelephoneTestdataBuilder countryCode(Integer countryCode) {
		this.countryCode = countryCode;
		return this;
	}

	public TelephoneTestdataBuilder number(Integer number) {
		this.number = number;
		return this;
	}

	public TelephoneTestdataBuilder person(Person person) {
		this.person = person;
		return this;
	}

	public TelephoneTestdataBuilder telephoneType(TelephoneType telephoneType) {
		this.telephoneType = telephoneType;
		return this;
	}

	public Integer getCountryCode() {
		return countryCode;
	}

	public Integer getNumber() {
		return number;
	}

	public Person getPerson() {
		if (person != null) {
			return person;
		}
		return hasEntityManager() ? new PersonTestdataBuilder(
				getEntityManager()).buildAndSave()
				: new PersonTestdataBuilder().build();
	}

	public TelephoneType getTelephoneType() {
		return telephoneType != null ? telephoneType : TELEPHONETYPE;
	}

	@Override
	public Telephone build() {
		Telephone telephone = new Telephone();
		telephone.setCountryCode(getCountryCode());
		telephone.setNumber(getNumber());
		telephone.setPerson(getPerson());
		telephone.setTelephoneType(getTelephoneType());
		return telephone;
	}

}
