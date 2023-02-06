package org.pojo;

import org.baseclass.Baseclass;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends Baseclass {
    //non-parameterized constructor
	public LoginPojo() {
		PageFactory.initElements(driver, this);
	}
	
	//private webelements
	@CacheLookup
	@FindBy(id = "email")
	private WebElement emailBox;
	@CacheLookup
	@FindBy(name = "pass")
	private WebElement passBox;
	@CacheLookup
	@FindBy(id = "u_0_5_12")
	private WebElement loginBtn;
	
	@CacheLookup
	@FindBys({
		@FindBy(xpath="//button[text()='Log in']"),@FindBy(id = "u_0_5_12"),
		@FindBy(name ="login"),@FindBy(xpath="//button[@value='1']")
	})
	private WebElement loginFindBys;
	@CacheLookup
	@FindAll({
		@FindBy(xpath="//button[text()='Log in']"),@FindBy(id = "u_0_5_12"),
		@FindBy(name ="login"),@FindBy(xpath="//button[@value='1']")
	})
	private WebElement loginClk;
	public WebElement getEmailBox() {
		return emailBox;
	}
	public WebElement getPassBox() {
		return passBox;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public WebElement getLoginFindBys() {
		return loginFindBys;
	}
	
	public WebElement getLoginClk() {
		return loginClk;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
