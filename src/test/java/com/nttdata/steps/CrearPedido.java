package com.nttdata.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearPedido {
    private static String URL = null;


    public void ingresarUrl(String url) {
        URL = url;
    }

    ;

    private static String CREAR_PEDIDO = "https://petstore.swagger.io/v2/store/order";

    @Step("Crear pedido {1} en PetStore")


    public void crearpedido(String id, String petId, String quantity, String shipDate, String status, String complete) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": " + id + ",\n" +
                        "  \"petId\": " + petId + ",\n" +
                        "  \"quantity\": " + quantity + ",\n" +
                        "  \"shipDate\": \"" + shipDate + "\",\n" +
                        "  \"status\": \"" + status + "\",\n" +
                        "  \"complete\": " + complete + "\n" +
                        "}")
                .log().all()
                .post(CREAR_PEDIDO)
                .then()
                .log().all()
        ;
    }

    public static void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    public boolean BuscarPedido(String id) {
        boolean existePedido = false;
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .log().all()
                .get(CREAR_PEDIDO + "/" + id)
                .then()
                .log().all()
        ;
        if (lastResponse().statusCode() == 200) {
            existePedido = true;
        }
        return existePedido;
    }


    public void validarPedidoID(String id) {
        restAssuredThat(response -> response.body("id", equalTo(Integer.parseInt(id))));

    }
    public void validarPetID(String petId) {
        restAssuredThat(response -> response.body("petId", equalTo(Integer.parseInt(petId))));

    }
    public void validarQuantity(String quantity) {
        restAssuredThat(response -> response.body("quantity", equalTo(Integer.parseInt(quantity))));

    }

}

