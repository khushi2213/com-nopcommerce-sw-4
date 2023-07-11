package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {
    By welcomePageSignInText = By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]");
    By checkoutAsGuestButton = By.xpath("//button[contains(text(),'Checkout as Guest')]");
    By registerButton = By.xpath("//button[contains(text(),'Register')]");

    public String getWelcomePageSignInText() {
        return getTextFromElement(welcomePageSignInText);
    }

    public void clickOnCheckoutAsGuestButton() {
        clickOnElement(checkoutAsGuestButton);
    }

    public void clickOnRegisterButton() {
        clickOnElement(registerButton);
    }
}
