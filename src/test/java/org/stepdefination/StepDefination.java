package org.stepdefination;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.baseclass.Baseclass;
import org.openqa.selenium.WebElement;
import org.pojo.Forgotten;
import org.pojo.LoginPojo;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination extends Baseclass{
	LoginPojo l;
	  Forgotten f;
@Given("User have to launch browser and Facebook url")
public void user_have_to_launch_browser_and_Facebook_url() {
    openBrowser();
    lanchUrl("https://www.facebook.com/");
}

@Given("User have to maxmize window")
public void user_have_to_maxmize_window() {
  maximizeWindow();
}

@When("User have to pass Valid username and Invalid password")
public void user_have_to_pass_Valid_username_and_Invalid_password() {
    l=new LoginPojo();
   WebElement emailBox = l.getEmailBox();
   passvalue(emailBox, "smaruthu30@gmail.com");
   WebElement passBox = l.getPassBox();
   passvalue(passBox, "1234567");
}
 // scenario -1
@When("User have to pass InValid username and Invalid password")
public void user_have_to_pass_InValid_username_and_Invalid_password(DataTable d) {
    Map<String, String> m = d.asMap(String.class, String.class);
    String email = m.get("username");
    l =new LoginPojo();
    WebElement emailBox = l.getEmailBox();
    passvalue(emailBox, email);
    WebElement passBox = l.getPassBox();
    passvalue(passBox, m.get("password1")); 
    
}
//scenario -2
@When("User have to pass InValid username and Valid password")
public void user_have_to_pass_InValid_username_and_Valid_password(DataTable d) {
   List<Map<String, String>> li = d.asMaps();
   Map<String, String> m = li.get(2);
   String email = m.get("username");
   l =new LoginPojo();
  WebElement emailBox = l.getEmailBox();
  passvalue(emailBox, email);
   WebElement passBox = l.getPassBox();
   passvalue(passBox, li.get(0).get("password"));
   
}


@Then("User have to click login button")
public void user_have_to_click_login_button() {
   WebElement clk = l.getLoginClk();
   elementClick(clk);
}
//forgotten password scenario
@When("User have to click forgotten password")
public void user_have_to_click_forgotten_password() {
   f=new Forgotten();
  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  WebElement forgotBn = f.getForgotBn();
  elementClick(forgotBn);
}

@When("User have to enter Invalid mobile number")
public void user_have_to_enter_Invalid_mobile_number() {
   WebElement txtBox = f.getTxtBox();
   passvalue(txtBox, "1234567890");
}

@Then("User have to click search button")
public void user_have_to_click_search_button() {
    WebElement searchbtn = f.getSearchbtn();
    elementClick(searchbtn);
}


@Then("User have to reach invalid login page")
public void user_have_to_reach_invalid_login_page() {
	String url = currentUrl();
    if (url.contains("privacy_mutation_token")) {
		System.out.println("user have to invalid login page");
	}
    else {
		System.out.println("user not in invalid login page");
	}
}

}
