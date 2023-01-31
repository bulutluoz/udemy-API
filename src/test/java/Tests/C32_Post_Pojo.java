package Tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoHerokuappBookingdates;
import pojos.PojoHerokuappRequestBody;
import pojos.PojoHerokuappResponseBody;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C32_Post_Pojo extends BaseUrlHerokuapp {
    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un asagidaki gibi oldugunu test edin.
    	                Request body
    	           {
    	                "firstname" : "Ahmet",
    	                "lastname" : “Bulut",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }
    	            	Response Body // expected data
    	            {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                        ,
                        "additionalneeds":"wi-fi"
                    }
     */

    @Test
    public void test01(){
        // 1- Request url ve body olustur
        specHerokuapp.pathParam("pp1","booking");

        PojoHerokuappBookingdates bookingdatesPojo=
                new PojoHerokuappBookingdates("2021-06-01","2021-06-10");

        PojoHerokuappRequestBody requestBodyPojo=
                new PojoHerokuappRequestBody("Ahmet","Bulut",500,false,bookingdatesPojo,"wi-fi");

        // 2- Soruda varsa expected data olustur
        bookingdatesPojo= new PojoHerokuappBookingdates("2021-06-01","2021-06-10");

        PojoHerokuappRequestBody bookingPojo=
                new PojoHerokuappRequestBody("Ahmet","Bulut",500,false,bookingdatesPojo,"wi-fi");

        PojoHerokuappResponseBody expectedResponseBodyPojo=
                new PojoHerokuappResponseBody(24,bookingPojo);

        /*
        PojoHerokuappResponseBody{
            bookingid=24,
            booking= PojoHerokuappRequestBody{
                        firstname='Ahmet',
                        lastname='Bulut',
                        totalprice=500,
                        depositpaid=false,
                        bookingdates=PojoHerokuappBookingdates{
                                        checkin='2021-06-01',
                                        checkout='2021-06-10'},
                        additionalneeds='wi-fi'}}

         */
        // 3 - Response olustur, request gonderip sonucu response'a ata
        Response response= given().spec(specHerokuapp).contentType(ContentType.JSON)
                                .when().body(requestBodyPojo)
                                .post("{pp1}");

        PojoHerokuappResponseBody responsePojo= response.as(PojoHerokuappResponseBody.class);
        /*
        PojoHerokuappResponseBody{
                bookingid=3090,
                booking=PojoHerokuappRequestBody{
                            firstname='Ahmet',
                            lastname='Bulut',
                            totalprice=500,
                            depositpaid=false,
                            bookingdates=PojoHerokuappBookingdates{
                                            checkin='2021-06-01',
                                            checkout='2021-06-10'},
                            additionalneeds='wi-fi'}}

         */

        // 4- Assertion
        //   expectedResponseBodyPojo  <=====> responsePojo

        assertEquals(expectedResponseBodyPojo.getBooking().getFirstname(),
                     responsePojo.getBooking().getFirstname());

        assertEquals(expectedResponseBodyPojo.getBooking().getLastname(),
                     responsePojo.getBooking().getLastname()   );

        assertEquals(expectedResponseBodyPojo.getBooking().getTotalprice(),
                     responsePojo.getBooking().getTotalprice());

        assertEquals(expectedResponseBodyPojo.getBooking().isDepositpaid(),
                     responsePojo.getBooking().isDepositpaid());

        assertEquals(expectedResponseBodyPojo.getBooking().getAdditionalneeds(),
                     responsePojo.getBooking().getAdditionalneeds()   );

        assertEquals(expectedResponseBodyPojo.getBooking().getBookingdates().getCheckin(),
                     responsePojo.getBooking().getBookingdates().getCheckin());

        assertEquals(expectedResponseBodyPojo.getBooking().getBookingdates().getCheckout(),
                     responsePojo.getBooking().getBookingdates().getCheckout());

    }
}
