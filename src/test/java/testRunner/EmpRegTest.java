package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="featurefiles/Employee.feature",glue="stepdefinitions",
plugin= {"com.cucumber.listener.ExtentCucumberFormatter:reports/empregresult.html"})
public class EmpRegTest 
{

	
		
}
