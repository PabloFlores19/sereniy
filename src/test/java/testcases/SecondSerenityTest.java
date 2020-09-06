package testcases;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SecondSerenityTest extends PageObject {

    @Managed
    WebDriver driver;

    WebElementFacade input;
    WebElementFacade link;

    @Test
    public void secondTestSerenity() throws InterruptedException {
        driver.get("https://www.google.com");
        input = $(By.name("q"));
        link = $(By.cssSelector(".g > div > .rc .LC20lb"));
        Assert.assertTrue("Input element not found", input.isVisible());
        input.typeAndEnter("Twitch");

        link.click();

    }
}
