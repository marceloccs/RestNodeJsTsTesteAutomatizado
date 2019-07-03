package br.com.mtools.nodeRest.teste_rest;

import static org.junit.Assert.assertEquals;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.body.RequestBodyEntity;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class StepDefinition {

	private String urlContacts = "http://localhost:3000/contact";
	private RequestBodyEntity body;

	@Given("^Open the Chrome and launch the applications$")
	public void navigate() {
		System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
	}

	@When("^start create a user with firstName as \"(.*)\" and lastName as \"(.*)\" and email as \"(.*)\" and phone as \"(.*)\" and company as \"(.*)\"$")
	public void login(String firstName, String lastName, String email, Long phone, String company)
			throws UnirestException {

		body = Unirest.post(urlContacts)
				.header("Content-Type", "application/json")
				.body("{\"firstName\":\"" + firstName + "\", \"lastName\":\"" + lastName + "\"}");

		System.out.println(body.asJson().getBody());

	}

	@Then("^I verify the status in step if \"(.*)\"$")
	public void verifySuccessful(int valuesResponse) throws UnirestException {
		System.out.println(body.asJson().getStatusText());
		assertEquals("Teste request message", valuesResponse,body.asJson().getStatus() );

	}

}
