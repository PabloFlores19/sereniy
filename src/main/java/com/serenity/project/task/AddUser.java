package com.serenity.project.task;

import com.serenity.project.elements.CrudUserPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddUser implements Task {

    private final String name;
    private final String lastName;
    private final String address;
    private final String phone;

    public AddUser(String name, String lastName, String address, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public static AddUser intoDataBase(String name, String lastName, String address, String phone) {
        return instrumented(AddUser.class
                ,name,lastName, address, phone);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CrudUserPage.ADD_BUTTON),
                Click.on(CrudUserPage.NAME),
                Enter.theValue(name).into(CrudUserPage.NAME),
                Enter.theValue(name).into(CrudUserPage.NAME),
                Click.on(CrudUserPage.LAST_NAME),
                Enter.theValue(lastName).into(CrudUserPage.LAST_NAME),
                Click.on(CrudUserPage.ADDRESS),
                Enter.theValue(address).into(CrudUserPage.ADDRESS),
                Click.on(CrudUserPage.PHONE),
                Enter.theValue(phone).into(CrudUserPage.PHONE),
                Click.on(CrudUserPage.BTN_SAVE)
        );
    }
}
