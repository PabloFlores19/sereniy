package testcases;

import com.serenity.project.dataprovider.ApiGet;
import com.serenity.project.model.users.Datum;
import com.serenity.project.questions.GetUsersQuestion;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.serenity.project.questions.ResponseCode;
import com.serenity.project.task.GetUser;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(SerenityRunner.class)
public class SerenityGetApiTest {

    @Test
    public void callApiLocalHost(){
        ApiGet path = new ApiGet();
        Actor pablo = Actor.named("test Api local host")
                .whoCan(CallAnApi.at(path.getApi()));

        pablo.attemptsTo(
                GetUser.fromPage(1)
        );

        //Assert.assertEquals(SerenityRest.lastResponse().statusCode(), 200);
        pablo.should(
                seeThat("The response code", ResponseCode.was(), equalTo(200))
        );

        Datum user = new GetUsersQuestion().answeredBy(pablo)
                .getData().stream().filter(x -> x.getId() == 1).findFirst().orElse(null);

        pablo.should(
                seeThat("user is not null", act -> user, notNullValue())
                //seeThat recibe un question como segundo parametro con la expresión lambda
                //convertimos el objeto user en question
        );

        //si se ponen varios seeThat se comporta como soft assertion
        pablo.should(
                seeThat("the user email", act -> user.getEmail(), equalTo("george.bluth@reqres.in")),
                seeThat("the first name", act -> user.getFirstName(), equalTo("George")),
                seeThat("the last name is", act -> user.getLastName(), equalTo("Bluth")),
                seeThat("the avatar is", act -> user.getAvatar(), equalTo("https://s3.amazonaws." +
                        "com/uifaces/faces/twitter/calebogden/128.jpg"))
        );
    }


}
