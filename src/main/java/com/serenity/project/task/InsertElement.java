package com.serenity.project.task;

import com.serenity.project.elements.CrudUserPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class InsertElement {
    public static Performable term(String term) {
        return Task.where("looking for element",
                //Clear.field(SearchForm.SEARCH_FIELD),
                //Enter.theValue(term).into(SearchForm.SEARCH_FIELD),
                Click.on(CrudUserPage.ADD_BUTTON)


        ).with("term").of(term);
    }
}
