package testcases;

import main.elements.ApiGet;
import main.models.users.Datum;
import main.questions.GetUsersQuestion;
import main.questions.ResponseCode;
import main.task.GetUser;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SerenityRunner.class)
public class ValidationUserTest {

    @Test
    public void callApiLocalHost() {
        ApiGet path = new ApiGet();
        Actor pablo = Actor.named("test Api local host")
                .whoCan(CallAnApi.at(path.getApi()));

        pablo.attemptsTo(
                GetUser.fromPage(2)
        );

        pablo.should(
                seeThat("The response code", ResponseCode.was(), equalTo(200))
        );

        Datum data = new GetUsersQuestion().answeredBy(pablo).getData()
                .stream().filter(x -> x.getId() == 4).findFirst().orElse(null);

        pablo.should(
                seeThat("the user name is", actor -> data.getEmail().equals("eve.holt@reqres.in")),
                seeThat("the user last name is", actor -> data.getFirstName().equals("Eve")),
                seeThat("the user last name is", actor -> data.getLastName().equals("Holt"))
        );
    }
}