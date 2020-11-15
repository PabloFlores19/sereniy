package testcases;

import com.serenity.project.model.users.Person;
import com.serenity.project.steps.CrudPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@RunWith(SerenityRunner.class)
public class UpdateElementTest {

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
        crudPage.updateUserData("Jill", "Valentine", "Racoon City", "28");
        List<Person> list = crudPage.getFirstElementDataBase();
        valueName = validateData(list, Person::getNombre, "Jill");
        Assert.assertTrue(valueName);
    }

    @After
    public void tearDrop(){
        //driver.quit();
    }

    public boolean validateData(List<Person> list, Function<Person, String> getValue, String value){
        return list.stream()
                .filter(Objects::nonNull)
                .map(getValue)
                .filter(Objects::nonNull)
                .allMatch(x -> x.contains(value));
    }
}
