package devsu.e2e.pages;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

        public static final Target CHECKOUT_BUTTON = Target.the("BOTÓN PARA HCER EL CHECKOUT")
            .located(By.id("checkout"));
}
