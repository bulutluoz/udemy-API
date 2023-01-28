package TestDatalari;

import org.json.JSONObject;

public class TestDataHerokuapp {

    /*
    {
                        "firstname" : "Mehmet",
                        "lastname" : “Dag",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                "checkin" : "2021-06-01",
                                "checkout" : "2021-06-10"
                                },
                        "additionalneeds" : "wi-fi"
                        }
     */

    public static JSONObject jsonRequestBodyOlustur(){

        JSONObject requestBody= new JSONObject();
        JSONObject bookingdatesBody= new JSONObject();

        bookingdatesBody.put("checkin","2021-06-01");
        bookingdatesBody.put("checkout","2021-06-10");

        requestBody.put("firstname","Mehmet");
        requestBody.put("lastname","Dag");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",bookingdatesBody);
        requestBody.put("additionalneeds","wi-fi");

        return requestBody;

    }

    /*
    {
                         "bookingid":24,
                         "booking":{
                            "firstname":"Mehmet",
                            "lastname":"Dag",
                            "totalprice":500,
                            "depositpaid":false,
                            "bookingdates":{
                                    "checkin":"2021-06-01",
                                    "checkout":"2021-06-10"
                                            },
                            "additionalneeds":"wi-fi"
                                    }
                          }
     */

    public static JSONObject jsonResponseBodyOlustur(){

        JSONObject responseBody= new JSONObject();
        JSONObject bookingBody= jsonRequestBodyOlustur();

        responseBody.put("bookingid",24);
        responseBody.put("booking",bookingBody);

        return responseBody;
    }
}
