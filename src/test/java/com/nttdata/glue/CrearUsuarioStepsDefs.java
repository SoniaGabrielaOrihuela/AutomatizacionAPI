package com.nttdata.glue;

import com.nttdata.steps.CrearPedido;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class CrearUsuarioStepsDefs {

    @Steps

    CrearPedido Crearpedido;


    @Then("el código de respuesta es {int}")
    public void elCódigoDeRespuestaEs(int statusCode) {
        CrearPedido.validarCodigoRespuesta(statusCode);
    }


    @When("creo el pedido con id {string}, petId {string}, quantity {string},shipDate {string}, status {string}, complete {string}")
    public void creoElPedidoConIdPetIdQuantityShipDateStatusComplete
            (String id, String petId, String quantity, String shipDate, String status, String complete) {
        Crearpedido.crearpedido(id, petId, quantity, shipDate, status, complete);
    }

    @Given("el usuario ingresa a la url {string}")
    public void elUsuarioIngresaALaUrl(String url) {
        Crearpedido.ingresarUrl(url);
    }


    @When("busca el pedido con id {string}")
    public void buscaElPedidoConId(String id) {
        Assert.assertTrue("No existe el ID del pedido", Crearpedido.BuscarPedido(id));
    }


    @And("el id del pedido es {string}")
    public void elIdDelPedidoEs(String id) {
        Crearpedido.validarPedidoID(id);
    }
    @And("el Petid del pedido es {string}")
    public void validarPetID(String petId) {
        Crearpedido.validarPetID(petId);
    }
    @And("la cantidad del pedido es {string}")
    public void validarQuantity(String quantity) {
        Crearpedido.validarQuantity(quantity);
    }

}

