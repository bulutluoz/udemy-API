package Tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C20_BaseUrlHerokuapp2 extends BaseUrlHerokuapp {


    @Test
    public void test01() {
 /*
        2- https://restful-booker.herokuapp.com/booking endpointine
        asagidaki body’ye sahip bir POST request gonderdigimizde
        donen response’un
            status code’unun 200 oldugunu
            ve “firstname” degerinin “Ahmet” oldugunu test edin

            {
            "firstname" : "Ahmet",
            "lastname" : “Bulut",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
                   "checkin" : "2021-06-01",
                   "checkout" : "2021-06-10"
                      },
            "additionalneeds" : "wi-fi" }
         */

        // 1- endpoint ve request body olustur

        specHerokuapp.pathParam("pp1","booking");

        JSONObject requestBody= new JSONObject();
        JSONObject rezervasyonTarihleriJson= new JSONObject();

        rezervasyonTarihleriJson.put("checkin","2021-06-01");
        rezervasyonTarihleriJson.put("checkout","2021-06-10");

        requestBody.put("firstname","Ahmet");
        requestBody.put("lastname","Bulut");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",rezervasyonTarihleriJson);
        requestBody.put("additionalneeds","wi-fi");

        // 2- expected data olustur
        // 3- request gonder ve donen response'i kaydet

        Response response= given().contentType(ContentType.JSON)
                                .when().spec(specHerokuapp).body(requestBody.toString())
                                .post("/{pp1}");

        // 4- Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("booking.firstname", Matchers.equalTo("Ahmet"));
    }
}
