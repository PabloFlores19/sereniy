package com.serenity.project.task;

import com.serenity.project.performable.CrudDemoPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theCrudeHomePage() {
        return Task.where("open the crud page",
                Open.browserOn().the(CrudDemoPage.class)
        );
    }
}
