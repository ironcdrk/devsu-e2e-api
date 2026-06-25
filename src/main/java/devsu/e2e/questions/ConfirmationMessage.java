package devsu.e2e.questions;

import devsu.e2e.pages.LastCheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ConfirmationMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return LastCheckoutPage.CONFIRMATION_MESSAGE
                .resolveFor(actor)
                .getText();
    }

    public static ConfirmationMessage displayed() {
        return new ConfirmationMessage();
    }
}