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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.adminshell.aas.v3.model.AssetAdministrationShell;

/**
 * Implements the AAS Repository API as in-memory variant
 *
 * @author conradi, schnicke
 *
 */
public class InMemoryAasRepository implements AasRepository {

	private Map<String, AasService> aasProviders = new LinkedHashMap<>();

	private AasServiceFactory aasApiFactory;

	public InMemoryAasRepository(AasServiceFactory aasApiFactory) {
		this.aasApiFactory = aasApiFactory;
	}

	@Override
	public List<AssetAdministrationShell> getAASList() {
		return aasProviders.values().stream().map(p -> p.getAAS()).collect(Collectors.toList());
	}

	@Override
	public AssetAdministrationShell getAAS(String aasId) {
		return aasProviders.get(aasId).getAAS();
	}

	@Override
	public void createAAS(AssetAdministrationShell aas) {
		aasProviders.put(aas.getIdentification().getIdentifier(), aasApiFactory.create(aas));
	}

	@Override
	public void updateAAS(AssetAdministrationShell aas) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void deleteAAS(String aasId) {
		aasProviders.remove(aasId);
	}

}
