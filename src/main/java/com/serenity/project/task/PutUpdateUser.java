package com.serenity.project.task;

import com.serenity.project.model.users.PutUserInfo;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutUpdateUser implements Task {

    private final PutUserInfo userInfo;

    public PutUpdateUser(PutUserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public static Performable withInfo(PutUserInfo userInfo){
        return instrumented(PutUpdateUser.class, userInfo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("/users/2").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo))
        );
    }
}
