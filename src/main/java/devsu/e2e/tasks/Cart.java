package devsu.e2e.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import devsu.e2e.pages.CartPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Cart {

    public static Task startCheckout() {
        return Task.where("{0} inicia el checkout",
                WaitUntil.the(CartPage.CHECKOUT_BUTTON, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(CartPage.CHECKOUT_BUTTON)
        );
    }

}