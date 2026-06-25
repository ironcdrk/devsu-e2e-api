package altiora.pages;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {

        public static final Target FIRST_NAME_INPUT = Target.the("CAMPO PARA NOMBRE")
            .located(By.id("first-name"));

        public static final Target LAST_NAME_INPUT = Target.the("CAMPO PARA APELLIDO")
            .located(By.id("last-name"));

        public static final Target POSTAL_CODE_INPUT = Target.the("CAMPO PARA CODIGO POSTAL")
            .located(By.id("postal-code"));
            
        public static final Target CONTINUE_BUTTON = Target.the("BOTON PARA CHECKOUT 1/2")
            .located(By.id("continue"));
        //postal-code
}

 