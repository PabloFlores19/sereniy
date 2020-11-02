package com.serenity.project.performable;

import com.serenity.project.elements.CrudUserPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.ensure.Ensure;

public class ValidatePage implements Performable{

    public static Performable theElements() {
        return new ValidatePage();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(CrudUserPage.ADD_BUTTON).isEnabled()
        );
    }
}
