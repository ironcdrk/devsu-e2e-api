package altiora.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import altiora.pages.HomePage;
import altiora.tasks.*;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class PurchaseStepDef {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("el usuario accede al sitio SauceDemo")
    public void elUsuarioAccedeAlSitioSauceDemo() {

        theActorCalled("standard_user").attemptsTo(
            NavigateTo.HomePage()
        );
    }

    @When("ingresa el usuario {string} y password {string}")
    public void ingresaelusuarioypassword(String username, String password) {

        theActorCalled("standard_user").attemptsTo(                
                Login.withCredentials(username, password)
        );
    }

    @When("agrega el producto {string} al carrito")
    public void agregaElProductoAlCarrito(String productName) {
        theActorCalled("standard_user").attemptsTo(
                Dashboard.addProductToCart(productName)
        );
    }

    @And("abre el carrito de compras")
    public void abreElCarritoDeCompras() {
        theActorCalled("standard_user").attemptsTo(
                Dashboard.openCart()
        );
    }

    @And("inicia el checkout")
    public void iniciaElCheckout() {
        theActorCalled("standard_user").attemptsTo(
                Cart.startCheckout()
        );
    }

    @And("completa el formulario con nombre {string}, apellido {string} y codigo postal {string}")
    public void completaElFormularioConNombreApellidoYCodigoPostal(
            String firstName,
            String lastName,
            String postalCode
    ) {
        theActorCalled("standard_user").attemptsTo(
                Checkout.fillForm(firstName, lastName, postalCode)
        );
    }

    @And("finaliza la compra")
    public void finalizaLaCompra() {
        theActorCalled("standard_user").attemptsTo(
                Checkout.finish()
        );
    }

    @Then("visualiza el mensaje de confirmacion {string}")
    public void visualizaElMensajeDeConfirmacion(String confirmationMessage) {
        theActorCalled("standard_user").attemptsTo(
                Checkout.validateConfirmationMessage(confirmationMessage)
        );
    }

}
