package testcases;

import com.serenity.project.steps.CrudPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class DeleteElement {

    private boolean valueName;

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
        int getFirstValues = crudPage.getRows();
        crudPage.deleteUserData();
        int getLastValues = crudPage.getRows();
        Assert.assertNotEquals(getFirstValues, getLastValues);
    }

    @After
    public void tearDrop(){
        //driver.quit();
    }
}
