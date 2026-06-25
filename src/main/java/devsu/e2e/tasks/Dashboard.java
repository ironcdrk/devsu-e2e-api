package altiora.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import altiora.pages.DashboardPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Dashboard{

    public static Task addProductToCart(String productName) {
        return Task.where("{0} agrega el producto " + productName + " al carrito",
                WaitUntil.the(DashboardPage.ADD_BACKPACK_BUTTON, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(DashboardPage.ADD_BACKPACK_BUTTON)
        );
    }

    public static Task openCart() {
        return Task.where("{0} abre el carrito de compras",
                WaitUntil.the(DashboardPage.CART_BUTTON, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(DashboardPage.CART_BUTTON)
        );
    }
}