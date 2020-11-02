package testcases;

import com.serenity.project.steps.CrudPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class CrudWebValidationTest {

    @Steps
    CrudPage crudPage;

    @Before
    public void setChrome(){
        crudPage.setTheStage();
        crudPage.onCrudPage("Pablo");
    }

    @Test
    public void testValidationCrudPage(){
        crudPage.validationPage();
        crudPage.addUserData("Pablo Pantoja", "Flores", "Address", "45345345");
       // crudPage.validateInsertInWebPage("Pablo Pantoja", "Flores", "Address", "45345345");
        System.out.println(crudPage.getElementsDatabase());
    }

    @After
    public void tearDrop(){
        //driver.quit();
    }
}
