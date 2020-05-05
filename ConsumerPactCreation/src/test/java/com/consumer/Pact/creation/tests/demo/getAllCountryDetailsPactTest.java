package com.consumer.Pact.creation.tests.demo;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

import org.junit.Rule;
import org.junit.Test;

import com.consumer.clients.demo.getAllCountryDetailsClient;


import java.util.HashMap;
import java.util.Map;



public class getAllCountryDetailsPactTest {
	@Rule
	public PactProviderRuleMk2 provider = new PactProviderRuleMk2("getAllCountryDetailsService", "localhost", 1233, this);

	@Pact(consumer = "getAllCountryDetailsConsumer")
	public RequestResponsePact createPact(PactDslWithProvider builder) throws Exception {
		Map<String, String> headers = new HashMap();
		headers.put("Content-Type", "application/json");
		

		DslPart countryDetails= new PactDslJsonBody()
				
				.object("RestResponse")
				.array("messages")
				.stringType("Total [249] records found.")
			    .closeArray()
			    .minArrayLike("result", 3, 249)
				.stringType("name","India")
				.stringType("alpha2_code","IN")
				.stringType("alpha3_code","IND")
				.closeArray()
				.closeObject()
				.asBody();
				
				

		return builder
				.given("There are 249 country records with ISOCode details")
				.uponReceiving("A request for All countryDetails")
				.path("/country/get/all")
				.method("GET")
				.willRespondWith().
				status(200).
				headers(headers).
				body(countryDetails).toPact();

	}

	@Test()
	@PactVerification()
	public void doTest() {
		System.setProperty("pact.rootDir", "../pacts");
		String cName = new getAllCountryDetailsClient(provider.getPort()).getCountryDetails();
		//System.out.println("According to test fName=" + cName);

	}

}
