package com.serenity.project.steps;

import com.serenity.project.elements.CrudUserPage;
import com.serenity.project.config.AppConfig;
import com.serenity.project.config.DataConfiguration;
import com.serenity.project.model.users.Person;
import com.serenity.project.model.PersonRepository;
import com.serenity.project.task.AddUser;
import com.serenity.project.task.NavigateTo;
import com.serenity.project.performable.ValidatePage;
import com.serenity.project.task.InsertElement;
import com.serenity.project.task.ValidateInsert;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Step;
import org.apache.commons.dbcp.BasicDataSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;

public class CrudPage {

    CrudUserPage user;


    @Step("This step will ignore the ssl certs")
    public WebDriver ignoreSsl(WebDriver webDriver){
        ChromeOptions options = new ChromeOptions();
        options.setCapability("acceptInsecureCerts", true);
        return webDriver = new ChromeDriver(options);
    }

    @Step("This step get de crud url")
    public String getCrudUrl(){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(DataConfiguration.class);
        BasicDataSource ds = (BasicDataSource) context.getBean("dataSourceCrud");
        return ds.getUrl();
    }

    @Step("Set the environment")
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Step("Open the crud web page")
    public void onCrudPage(String actor) {
        theActorCalled(actor).attemptsTo(NavigateTo.theCrudeHomePage());
    }

    @Step("Validates if add button is present")
    public void validationPage(){
        ValidatePage.theElements();
    }

    @Step
    public void AddUser(String term) {
        withCurrentActor(InsertElement.term(term));
    }

    @Step("Add a new user")
    public void addUserData(String name, String lastName, String address, String phone){
        withCurrentActor(AddUser.intoDataBase(name, lastName, address, phone));
    }

    @Step("Validate insert into web")
    public void validateInsertInWebPage(String name, String lastName, String address, String phone){
        withCurrentActor(ValidateInsert.fromWebPage(name, lastName, address, phone));
    }

    @Step("query the data base")
    public List<Person> getElementsDatabase(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonRepository person = context.getBean(PersonRepository.class);
        return person.selectPerson();
    }



}
