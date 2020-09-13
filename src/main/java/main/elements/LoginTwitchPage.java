package main.elements;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import main.daopages.LoginDAO;


public class LoginTwitchPage extends PageObject {

    public void searchForTwicth(){
      String url = getDriver().getCurrentUrl();
      Assert.assertTrue(url.contains("google"));
      $(By.name("q")).typeAndEnter("twitch");
    }

    public void enterUserNamePass(){
        String urlTwitch = getDriver().getCurrentUrl();
        $(By.cssSelector(".g > div > .rc .LC20lb")).click();
        Assert.assertTrue(urlTwitch.contains("twitch"));
        $(By.cssSelector(".tw-core-button--secondary > .tw-align-items-center > .tw-flex-grow-0")).click();

        ApplicationContext context = new FileSystemXmlApplicationContext("/src/spring-context.xml");
        LoginDAO element = context.getBean("login", LoginDAO.class);
        $(By.id("login-username")).type(element.getUser());
        $(By.id("password-input")).typeAndEnter(element.getPass());
    }

    public void verifyLogin(){
        String urlTwitch = getDriver().getCurrentUrl();
        Assert.assertTrue(urlTwitch.contains("twitch"));
    }
}
