package altiora.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import altiora.pages.CheckoutPage;
import altiora.pages.SecondCheckoutPage;
import altiora.pages.LastCheckoutPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Checkout{

    public static Task fillForm(String firstName, String lastName, String postalCode) {
        return Task.where("{0} completa el formulario de checkout",
                WaitUntil.the(CheckoutPage.FIRST_NAME_INPUT, isVisible())
                        .forNoMoreThan(10).seconds(),
                Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME_INPUT),
                Enter.theValue(lastName).into(CheckoutPage.LAST_NAME_INPUT),
                Enter.theValue(postalCode).into(CheckoutPage.POSTAL_CODE_INPUT),
                Click.on(CheckoutPage.CONTINUE_BUTTON)
        );
    }

    public static Task finish() {
        return Task.where("{0} finaliza la compra",
                WaitUntil.the(SecondCheckoutPage.FINISH_BUTTON, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(SecondCheckoutPage.FINISH_BUTTON)
        );
    }

    public static Task validateConfirmationMessage(String message) {
        return Task.where("{0} valida el mensaje de confirmacion",
                WaitUntil.the(LastCheckoutPage.CONFIRMATION_MESSAGE, isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }

}