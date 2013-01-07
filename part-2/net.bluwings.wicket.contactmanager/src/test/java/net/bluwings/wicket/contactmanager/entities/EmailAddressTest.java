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
import javax.validation.ConstraintViolationException;

import net.bluwings.wicket.contactmanager.entities.testdata.EmailAddressTestdataBuilder;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import de.akquinet.jbosscc.needle.db.transaction.VoidRunnable;
import de.akquinet.jbosscc.needle.junit.DatabaseRule;

public class EmailAddressTest {

	@Rule
	public DatabaseRule databaseRule = new DatabaseRule();

	private EntityManager em = databaseRule.getEntityManager();

	@Test
	public void testPersist() throws Exception {
		EmailAddress emailAddress = new EmailAddressTestdataBuilder(em)
				.buildAndSave();

		EmailAddress emailAddressFromDb = em.find(EmailAddress.class,
				emailAddress.getId());

		Assert.assertEquals(emailAddress.getId(), emailAddressFromDb.getId());
		Assert.assertNotSame(emailAddress, emailAddressFromDb);
		Assert.assertEquals(emailAddress.getPerson().getFirstName(), "John");
	}

	@Test(expected = ConstraintViolationException.class)
	public void testPersistWithoutPerson() throws Exception {
		final EmailAddress emailAddress = new EmailAddressTestdataBuilder(em)
				.build();
		emailAddress.setPerson(null);

		databaseRule.getTransactionHelper().executeInTransaction(
				new VoidRunnable() {

					@Override
					public void doRun(EntityManager entityManager)
							throws Exception {
						entityManager.persist(emailAddress);

					}
				});
	}
}
