package com.serenity.project.steps;

import com.serenity.project.elements.LoginTwitchPage;
import net.thucydides.core.annotations.Step;

public class LoginPage {

    LoginTwitchPage loginTwitchPage;

    @Step("This step will search for twictg page")
    public void searchWebTwitch(){
        loginTwitchPage.searchForTwicth();
    }

    @Step("This step will login into twitch")
    public void enterCredentials(){
        loginTwitchPage.enterUserNamePass();
    }

    @Step("This step will validate the page")
    public void validatePage(){
        loginTwitchPage.verifyLogin();
    }
}
