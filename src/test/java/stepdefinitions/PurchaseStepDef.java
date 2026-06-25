package stepdefinitions;

import devsu.e2e.questions.ConfirmationMessage;
import devsu.e2e.tasks.Cart;
import devsu.e2e.tasks.Checkout;
import devsu.e2e.tasks.Dashboard;
import devsu.e2e.tasks.Login;
import devsu.e2e.tasks.NavigateTo;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

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
    public void ingresaElUsuarioYPassword(String username, String password) {
        theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(username, password)
        );
    }

    @When("agrega el producto {string} al carrito")
    public void agregaElProductoAlCarrito(String productName) {
        theActorInTheSpotlight().attemptsTo(
                Dashboard.addProductToCart(productName)
        );
    }

    @When("agrega los productos al carrito")
    public void agregaLosProductosAlCarrito(DataTable dataTable) {
        List<Map<String, String>> productos = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> fila : productos) {
            String productName = fila.get("producto");

            theActorInTheSpotlight().attemptsTo(
                    Dashboard.addProductToCart(productName)
            );
        }
    }

    @And("abre el carrito de compras")
    public void abreElCarritoDeCompras() {
        theActorInTheSpotlight().attemptsTo(
                Dashboard.openCart()
        );
    }

    @And("inicia el checkout")
    public void iniciaElCheckout() {
        theActorInTheSpotlight().attemptsTo(
                Cart.startCheckout()
        );
    }

    @And("completa el formulario con nombre {string}, apellido {string} y codigo postal {string}")
    public void completaElFormularioConNombreApellidoYCodigoPostal(
            String firstName,
            String lastName,
            String postalCode
    ) {
        theActorInTheSpotlight().attemptsTo(
                Checkout.fillForm(firstName, lastName, postalCode)
        );
    }

    @And("finaliza la compra")
    public void finalizaLaCompra() {
        theActorInTheSpotlight().attemptsTo(
                Checkout.finish()
        );
    }

    @Then("visualiza el mensaje de confirmacion {string}")
    public void visualizaElMensajeDeConfirmacion(String expectedConfirmationMessage) {
        theActorInTheSpotlight().should(
                seeThat(
                        ConfirmationMessage.displayed(),
                        equalTo(expectedConfirmationMessage)
                )
        );
    }
}