package starter.test;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.google.com")
public class FindSomething extends PageObject {
    WebElementFacade keyWords;
    WebElementFacade searchButton;
    WebElementFacade elementFacade;

    public void lookingForSomething(String values){
        typeInto(keyWords, values);
        searchButton.click();
    }

    public boolean findElementInWeb(WebElementFacade elementFacade){
        return elementFacade.isVisible();
    }
}
