package br.com.lsena.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiRestTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://brasilapi.com.br/api";
    }

    @Test
    public void shouldReturnStatusCode200AndNuPagamentosIP() {
        String bankName = get("/banks/v1/260").then().statusCode(200).extract().path("name");
        assertEquals("NU PAGAMENTOS - IP", bankName);
    }

    @Test
    public void shouldReturnStatusCode404() {
        get("/banks/v1/2").then().statusCode(404);
    }
}
