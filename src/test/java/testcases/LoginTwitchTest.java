package testcases;

import main.elements.LoginTwitchPage;
import main.steps.LoginPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTwitchTest {

    LoginTwitchPage url;
    @Managed
    WebDriver webDriver;
    @Steps
    LoginPage loginPage;



    @Test
    public void login(){
        webDriver.get("https://www.google.com");
        loginPage.searchWebTwitch();
    }
}
