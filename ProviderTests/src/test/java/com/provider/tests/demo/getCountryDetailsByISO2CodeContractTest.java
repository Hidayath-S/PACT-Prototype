package com.provider.tests.demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.runner.RunWith;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.VerificationReports;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;

@RunWith(PactRunner.class)
@Provider("getCountryDetailsByISO2CodeService")
//@PactFolder("../pacts")
@PactBroker(host="localhost",port="8113")
@VerificationReports(value = {"json"}, reportDir = "../reports")
public class getCountryDetailsByISO2CodeContractTest {
	public getCountryDetailsByISO2CodeContractTest()  {
		System.setProperty("pact.verifier.publishResults", "true");
	}

	@TestTarget
	
	public final Target target= new HttpTarget("http", "localhost", 1235, "");

	@State({"There is a country with ISO2Code=IN"})
	public void getPacts() {
		System.out.println("There is a country with ISO2Code=IN");
	}}

	
	
