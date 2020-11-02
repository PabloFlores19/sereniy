package testcases;

import com.serenity.project.dataprovider.ApiGet;
import com.serenity.project.model.users.RegisterUserInfo;
import com.serenity.project.questions.ResponseCode;
import com.serenity.project.task.PostRegisterUser;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SerenityRunner.class)
public class RegisterUserPostTest {

    @Test
    public void registerUserTest(){
        ApiGet path = new ApiGet();
        Actor pablo = Actor.named("test Api local host")
                .whoCan(CallAnApi.at(path.getApi()));

        RegisterUserInfo registerUserInfo = new RegisterUserInfo();
        registerUserInfo.setName("morpheus");
        registerUserInfo.setJob("leader");
        registerUserInfo.setEmail("tobias.funke@reqres.in");
        registerUserInfo.setPassword("sereniry");
        pablo.attemptsTo(
                PostRegisterUser.withInfo(registerUserInfo)
        );

        pablo.should(
                seeThat("The response code", ResponseCode.was(), equalTo(200))
        );
    }
}
