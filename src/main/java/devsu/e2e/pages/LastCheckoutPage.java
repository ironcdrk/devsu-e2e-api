package altiora.pages;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class LastCheckoutPage {

        public static final Target CONFIRMATION_MESSAGE = Target.the("TITULO DE COMPRA SATISFACTORIA")
            .located(By.className("complete-header"));

        public static final Target BACK_BUTTON = Target.the("BOTON PARA REGRESAR AL HOME LUEGO DEL CHECKOUT")
            .located(By.id("back-to-products"));
        //postal-code
}

 