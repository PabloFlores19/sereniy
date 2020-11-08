package com.serenity.project.task;

import com.serenity.project.elements.CrudUserPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class DeleteUser implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
               Click.on(CrudUserPage.BTN_DELETE)
        );
    }
}
