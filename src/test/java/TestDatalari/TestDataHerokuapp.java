package TestDatalari;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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

    /*
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
     */

    public static Map<String,Object> requestBodyMapOlustur(){

        Map<String,Object> requestBodyMap= new HashMap<>();
        requestBodyMap.put("firstname","Ahmet");
        requestBodyMap.put("lastname","Bulut");
        requestBodyMap.put("totalprice",500.0);
        requestBodyMap.put("depositpaid",false);
        requestBodyMap.put("bookingdates",bookingdatesMapOlustur());
        requestBodyMap.put("additionalneeds","wi-fi");

        return requestBodyMap;
    }

    public static Map<String,String> bookingdatesMapOlustur(){

        Map<String,String > bookingdatesMap= new HashMap<>();
        bookingdatesMap.put("checkin","2021-06-01");
        bookingdatesMap.put("checkout","2021-06-10");

        return bookingdatesMap;
    }

    /*
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

    public static Map<String,Object> responseBodyMapOlustur(){

        Map<String,Object> responseBodyMap= new HashMap<>();

        responseBodyMap.put("bookingid",24);
        responseBodyMap.put("booking",requestBodyMapOlustur());

        return responseBodyMap;
    }
}
