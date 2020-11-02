package com.serenity.project.task;

import com.serenity.project.elements.CrudUserPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidateInsert implements Task {

    private final String name;
    private final String lastName;
    private final String address;
    private final String phone;

    public ValidateInsert(String name, String lastName, String address, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public static ValidateInsert fromWebPage(String name, String lastName, String address, String phone) {
        return instrumented(ValidateInsert.class
                ,name,lastName, address, phone);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(CrudUserPage.TEXT_NAME).value().contains(name),
                Ensure.that(CrudUserPage.TEXT_LAST_NAME).value().contains(lastName),
                Ensure.that(CrudUserPage.TEXT_ADDRESS).value().contains(address),
                Ensure.that(CrudUserPage.TEXT_PHONE).value().contains(phone),
                Ensure.that(CrudUserPage.BTN_EDIT).isDisplayed(),
                Ensure.that(CrudUserPage.BTN_DELETE).isDisplayed()
        );
    }
}
