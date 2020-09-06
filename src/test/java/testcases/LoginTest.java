package testcases;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import main.daopages.LoginDAO;
import main.steps.LoginPage;

@RunWith(SerenityRunner.class)
public class LoginTest  {

    @Managed
    WebDriver driver;

    @Steps
    LoginPage loginPage;

    @Test
    public void loginAsUser(){
        ApplicationContext context = new FileSystemXmlApplicationContext("/src/spring-context.xml");
        LoginDAO element = context.getBean("login", LoginDAO.class);
        driver.get(element.getUrl());
        loginPage.searchWebTwitch();
        loginPage.enterCredentials();
        loginPage.validatePage();

    }
}
