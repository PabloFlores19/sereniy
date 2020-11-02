package com.serenity.project.elements;

import org.openqa.selenium.By;
import net.serenitybdd.screenplay.targets.Target;

public class CrudUserPage {

    //formulary
    public static Target ADD_BUTTON = Target.the("add button").located
            (By.xpath("//a[contains(text(),'Agregar')]"));
    public static Target BTN_SAVE = Target.the("btn save").
            located(By.xpath("//button[contains(.,'Guardar')]"));
    public static Target NAME = Target.the("input name").
            located(By.id("nombre"));
    public static Target LAST_NAME = Target.the("input last name").
            located(By.id("apellido"));
    public static Target ADDRESS = Target.the("input address").
            located(By.id("direccion"));
    public static Target PHONE = Target.the("input phone").
            located(By.id("telefono"));

    //table
    public static Target TEXT_NAME = Target.the("text name").
            located(By.cssSelector("td:nth-child(1)"));
    public static Target TEXT_LAST_NAME = Target.the("text last name").
            located(By.cssSelector("td:nth-child(2)"));
    public static Target TEXT_ADDRESS = Target.the("text address").
            located(By.cssSelector("td:nth-child(3)"));
    public static Target TEXT_PHONE = Target.the("text phone").
            located(By.cssSelector("td:nth-child(4)"));
    public static Target BTN_EDIT = Target.the("edit button").
            located(By.xpath("//a[contains(.,'Editar')]"));
    public static Target BTN_DELETE = Target.the("edit button").
            located(By.xpath("//a[contains(.,'Eliminar')]"));



}
