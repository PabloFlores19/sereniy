package com.serenity.project.task;

import com.serenity.project.interactions.Post;
import io.restassured.http.ContentType;
import com.serenity.project.model.users.RegisterUserInfo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostRegisterUser implements Task{

    private final RegisterUserInfo userInfo;

    public PostRegisterUser(RegisterUserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public static Performable withInfo(RegisterUserInfo userInfo){
        return instrumented(PostRegisterUser.class, userInfo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/register").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo))
        );
    }
}
