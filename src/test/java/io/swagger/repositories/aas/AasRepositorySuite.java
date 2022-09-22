/*******************************************************************************
 * Copyright (C) 2021 the Eclipse BaSyx Authors
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * SPDX-License-Identifier: MIT
 ******************************************************************************/
package io.swagger.repositories.aas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import io.adminshell.aas.v3.model.AssetAdministrationShell;
import io.adminshell.aas.v3.model.IdentifierType;
import io.adminshell.aas.v3.model.impl.DefaultAssetAdministrationShell;
import io.adminshell.aas.v3.model.impl.DefaultIdentifier;

/**
 * Testsuite for implementations of the AasRepository interface
 * 
 * @author conradi, schnicke
 *
 */
public abstract class AasRepositorySuite {

	private AssetAdministrationShell aas1;

	// Choose AAS Id that needs encoding due to '/'
	private static final String aas1Id = "aas1/s";

	private AssetAdministrationShell aas2;
	private static final String aas2Id = "aas2";

	private AasRepository aasRepo;

	@Before
	public void initSuite() {
		aasRepo = getAggregatorFactory().create();
		createAASDummies();
	}

	private void createAASDummies() {
		aas1 = new DefaultAssetAdministrationShell.Builder()
				.identification(
						new DefaultIdentifier.Builder().identifier(aas1Id).idType(IdentifierType.CUSTOM).build())
				.build();

		aas2 = new DefaultAssetAdministrationShell.Builder()
				.identification(
						new DefaultIdentifier.Builder().identifier(aas2Id).idType(IdentifierType.CUSTOM).build())
				.build();
	}

	protected abstract AasRepositoryFactory getAggregatorFactory();

	@Test
	public void allAasRetrieval() throws Exception {
		aasRepo.createAAS(aas1);
		aasRepo.createAAS(aas2);

		Collection<AssetAdministrationShell> coll = aasRepo.getAASList();
		assertEquals(2, coll.size());

		assertTrue(coll.contains(aas1));
		assertTrue(coll.contains(aas2));
	}
}
