package org.pojo;

import org.baseclass.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forgotten extends Baseclass{

	public Forgotten() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Forgotten password?']")
	private WebElement forgotBn;
	@FindAll({
		@FindBy(name="email"),@FindBy(xpath="//input[@type='text']"),
		@FindBy(xpath="//input[contains(@aria-label,'address or mobile number']")
	})
	private WebElement txtBox;
	@FindAll({
		@FindBy(xpath="//button[text()='Search']"),@FindBy(id="did_submit"),
		@FindBy(xpath="//button[@type='submit']")
	})
	private WebElement searchbtn;
	public WebElement getForgotBn() {
		return forgotBn;
	}
	public WebElement getTxtBox() {
		return txtBox;
	}
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
}
