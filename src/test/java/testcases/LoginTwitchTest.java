package testcases;

import com.serenity.project.elements.LoginTwitchPage;
import com.serenity.project.steps.LoginPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@RunWith(SerenityRunner.class)
public class LoginTwitchTest {

    LoginTwitchPage url;
    WebDriver driver;
    @Steps
    LoginPage loginPage;



    @Test
    public void login(){
        ChromeOptions options = new ChromeOptions();
        options.setCapability("acceptInsecureCerts", true);
        driver = new ChromeDriver(options);
        driver.get("http://localhost:8080");
        loginPage.searchWebTwitch();
    }
}
