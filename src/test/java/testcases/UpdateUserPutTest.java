package testcases;

import main.elements.ApiGet;
import main.models.users.PutUserInfo;
import main.questions.ResponseCode;
import main.task.PutUpdateUser;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SerenityRunner.class)
public class UpdateUserPutTest {


    @Test
    public void testUsingPut(){
        ApiGet path = new ApiGet();
        Actor pablo = Actor.named("test Api local host")
                .whoCan(CallAnApi.at(path.getApi()));

        PutUserInfo putUserInfo = new PutUserInfo();
        putUserInfo.setName("morpheus");
        putUserInfo.setJob("zion resident");

        pablo.attemptsTo(
                PutUpdateUser.withInfo(putUserInfo)
        );

        pablo.should(
                seeThat("The response code", ResponseCode.was(), equalTo(200))
        );

    }
}
