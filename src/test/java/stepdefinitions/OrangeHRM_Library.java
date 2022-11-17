package stepdefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRM_Library 
{
	WebDriver driver;
	String empno;
	String username;
	
@Given("^I open browser with url \"([^\"]*)\"$")
public void launchApp(String url) 
{
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver  = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get(url);
	
}
    


@Then("^I should see login page$")
public void i_should_see_login_page() 
{
   if(driver.findElement(By.id("btnLogin")).isDisplayed())
   {
	   System.out.println("Application launched sucessfully");
   }
}

@When("^I eneter username as \"([^\"]*)\"$")
public void i_eneter_username_as(String uname) 
{
   driver.findElement(By.id("txtUsername")).sendKeys(uname);
}

@When("^enter password as \"([^\"]*)\"$")
public void enter_password_as(String pword) 
{
  driver.findElement(By.id("txtPassword")).sendKeys(pword);
}

@When("^click login$")
public void click_login() 
{
	driver.findElement(By.id("btnLogin")).click();
   
}

@Then("^I should see  admin module$")
public void i_should_see_admin_module() 
{
   if(driver.findElement(By.linkText("Admin")).isDisplayed())
   {
	   System.out.println("Admin login sucessfull");
   }
}

@When("^I click logout$")
public void logout()  
{
  driver.findElement(By.partialLinkText("Welcome")).click();
  driver.findElement(By.linkText("Logout")).click();
  
}



@When("^I close browser$")
public void i_close_browser() 
{
   driver.close();
}

@Then("^I should see an error message$")
public void i_should_see_an_error_message()  
{
	String errmsg =driver.findElement(By.id("spanMessage")).getText();
	if(errmsg.toLowerCase().contains("invalid"))
			{
		       System.out.println("Error msg displayed");
			}else
			{
				System.out.println("Error msg not displayed");
			}

}

@When("^I go to add employee page$")
public void i_go_to_add_employee_page()  
{
   driver.findElement(By.linkText("PIM")).click();
   driver.findElement(By.linkText("Add Employee")).click();
}

@When("^I enter firstname as \"([^\"]*)\"$")
public void i_enter_firstname_as(String fname) 
{
   driver.findElement(By.id("firstName")).sendKeys(fname);
   
}

@When("^enter lastname as \"([^\"]*)\"$")
public void enter_lastname_as(String lname) 
{
   driver.findElement(By.id("lastName")).sendKeys(lname);
}
@When("^click save$")
public void click_save() 
{
   empno =driver.findElement(By.id("employeeId")).getAttribute("value");
   driver.findElement(By.id("btnSave")).click();
}

@Then("^I should see new employee in emp list table$")
public void i_should_see_new_employee_in_emp_list_table() 
{
	 driver.findElement(By.linkText("PIM")).click();
	 driver.findElement(By.linkText("Employee List")).click();
	 driver.findElement(By.id("empsearch_id")).sendKeys(empno);
	 driver.findElement(By.id("searchBtn")).click();
	List<WebElement> row= driver.findElement(By.id("resultTable")).findElements(By.tagName("tr"));
	boolean res=false;
	for(int i=1;i<row.size();i++)
	{
		List<WebElement>col =row.get(i).findElements(By.tagName("td"));
		if(col.get(1).getText().equalsIgnoreCase(empno))
		{
			res=true;
			break;
		}
		if(res)
		{
			System.out.println("New employee registred sucessfully");
		}
		else
		{
			System.out.println("New employee not registred sucessfully");
		}
			
	}
		
	}

@When("^I go to user registration page$")
public void i_go_to_user_registration_page() 
{
	driver.findElement(By.linkText("Admin")).click();
	driver.findElement(By.id("btnAdd")).click();
	
   
}

@When("^I select userrole$")
public void i_select_userrole() 
{
   Select sel =new Select(driver.findElement(By.id("systemUser_userType")));
   sel.selectByVisibleText("ESS");
}

@When("^enter emplyoee name as \"([^\"]*)\"$")
public void enter_emplyoee_name_as(String empname)  
{
   driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(empname);
}

@When("^enter username as \"([^\"]*)\"$")
public void enter_username_as(String usname)
{
    driver.findElement(By.id("systemUser_userName")).sendKeys(usname);
}
@When("^enter user password as \"([^\"]*)\"$")
public void enter_user_password_as(String psd) 
{
	 driver.findElement(By.id("systemUser_password")).sendKeys(psd);
  
}

@When("^enter confirm password as \"([^\"]*)\"$")
public void enter_confirm_password_as(String psd)
{
	 driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(psd);
}


@When("^click savebtn$")
public void click_savebtn() throws InterruptedException 
{
	 username =driver.findElement(By.id("systemUser_userName")).getText();
	 Thread.sleep(2000);
	driver.findElement(By.id("btnSave")).click();
   
}

@Then("^i should see new user in the user registration list table$")
public void i_should_see_new_user_in_the_user_registration_list_table() throws InterruptedException  
{
	driver.findElement(By.id("searchSystemUser_userName")).sendKeys(username);
	Thread.sleep(2000);
	driver.findElement(By.id("searchBtn")).click();
	Thread.sleep(2000);
	List<WebElement> row =driver.findElement(By.id("resultTable")).findElements(By.tagName("tr"));
	
	for(int i=1;i<row.size();i++)
	{
		List<WebElement> col =row.get(i).findElements(By.tagName("td"));
		if(col.get(1).getText().equalsIgnoreCase(username))
		{
			System.out.println("User registration sucessful");
		}
	
	}
 }

}

