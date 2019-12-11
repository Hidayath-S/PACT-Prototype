package com.provider.tests.demo;



import org.junit.runner.RunWith;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.VerificationReports;
import au.com.dius.pact.provider.junit.loader.PactBroker;

import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;

@RunWith(PactRunner.class)
@Provider("getAllCountryDetailsService")
//@PactFolder("../pacts")
@PactBroker(host="localhost",port="8113")
@VerificationReports(value = {"json"}, reportDir = "../reports")
public class getAllCountryDetailsContractTest {
	public getAllCountryDetailsContractTest()  {
		System.setProperty("pact.verifier.publishResults", "true");
	}

	@TestTarget
	
	public final Target target= new HttpTarget("http", "localhost", 1235, "");

	@State({"There are 249 country records with ISOCode details"})
	public void getPacts() {
		System.out.println("There are 249 country records with ISOCode details");
	}}

	
	
