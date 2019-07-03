package br.com.mtools.nodeRest.teste_rest;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(format={"pretty","html:reports/test-report"},tags= "@selenium")
public class CucumberRunner {

}
