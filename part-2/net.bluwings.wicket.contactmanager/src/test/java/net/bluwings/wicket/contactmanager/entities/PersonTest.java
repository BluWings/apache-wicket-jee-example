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

import javax.persistence.EntityManager;

import net.bluwings.wicket.contactmanager.entities.testdata.PersonTestdataBuilder;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import de.akquinet.jbosscc.needle.junit.DatabaseRule;

public class PersonTest {

	@Rule
	public DatabaseRule databaseRule = new DatabaseRule();

	private EntityManager em = databaseRule.getEntityManager();

	@Test
	public void testPersist() {
		Person person = new PersonTestdataBuilder(em).buildAndSave();

		Person personFromDb = em.find(Person.class, person.getId());

		Assert.assertEquals(person.getId(), personFromDb.getId());
		Assert.assertNotSame(person, personFromDb);
		Assert.assertEquals(person.getFirstName(), "John");
		Assert.assertEquals(person.getLastName(), "Doe");
		Assert.assertEquals(Gender.MALE, personFromDb.getGender());
		Assert.assertNotEquals(Gender.FEMALE, personFromDb.getGender());
	}

}
