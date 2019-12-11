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


import com.consumer.clients.demo.getCompanyDetailsByIDClient;
import com.consumer.clients.demo.getCountryDetailsByISO2CodeClient;

import java.util.HashMap;
import java.util.Map;



public class getCountryDetailsByISO2CodePactTest {
	@Rule
	public PactProviderRuleMk2 provider = new PactProviderRuleMk2("getCountryDetailsByISO2CodeService", "localhost", 1233, this);
	
	@Pact(consumer = "getCountryDetailsByISO2CodeConsumerB")
	public RequestResponsePact createPact(PactDslWithProvider builder) throws Exception {
		Map<String, String> headers = new HashMap();
		headers.put("Content-Type", "application/json");
		
		DslPart countryDetails = new PactDslJsonBody()
				.object("RestResponse")
				.array("messages")
				.stringType("Country found matching code [IND].")
			    .closeArray()
				.object("result")	
				.stringType("name","India")
				.stringType("alpha2_code","IN")
				.stringType("alpha3_code","IND")
				.closeObject()
				.asBody();
				
		return builder
				.given("There is a country with ISO2Code=IN")
				.uponReceiving("A request for countryDetails with ISO2Code=IN")
				.path("/country/get/iso2code/IN")
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
		String countryName = new getCountryDetailsByISO2CodeClient(provider.getPort()).getCountryDetails();
		System.out.println("According to Pact creation test country name is "+countryName);
		

	}

}
