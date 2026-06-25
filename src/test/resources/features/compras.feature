@ProcesodeCompra
Feature: Compra de producto 

    Background:
        Given el usuario accede al sitio SauceDemo
        When ingresa el usuario "standard_user" y password "secret_sauce"

    Scenario: Compra exitosa de un producto
        #When agrega el producto "Sauce Labs Backpack" al carrito
        When agrega los productos al carrito
        | producto                  |
        | Sauce Labs Backpack       |
        | Sauce Labs Bike Light     |
        And abre el carrito de compras
        And inicia el checkout
        And completa el formulario con nombre "Carlos", apellido "Licto" y codigo postal "170811"
        And finaliza la compra
        Then visualiza el mensaje de confirmacion "Thank you for your order!"