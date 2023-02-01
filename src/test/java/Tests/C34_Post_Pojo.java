package Tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.pojosHavaDurumu.*;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C34_Post_Pojo {
    /*
     https://api.openweathermap.org/data/2.5/weather?q=London&appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0
     url’ine bir post request gonderdigimizde
     donen response’un asagidaki body’ye sahip oldugunu test ediniz
                        {
                    "coord": {
                        "lon": -0.1257,
                        "lat": 51.5085
                    },
                    "weather": [
                        {
                            "id": 804,
                            "main": "Clouds",
                            "description": "overcast clouds",
                            "icon": "04d"
                        }
                    ],
                    "base": "stations",
                    "main": {
                        "temp": 291.99,
                        "feels_like": 292.18,
                        "temp_min": 289.89,
                        "temp_max": 293.71,
                        "pressure": 1007,
                        "humidity": 86
                    },
                    "visibility": 8000,
                    "wind": {
                        "speed": 1.54,
                        "deg": 0
                    },
                    "clouds": {
                        "all": 90
                    },
                    "dt": 1627206846,
                    "sys": {
                        "type": 2,
                        "id": 2006068,
                        "country": "GB",
                        "sunrise": 1627186441,
                        "sunset": 1627243183
                    },
                    "timezone": 3600,
                    "id": 2643743,
                    "name": "London",
                    "cod": 200
                }
     */

    @Test
    public void test01(){
        // 1- Request url ve body olustur

        String url= "https://api.openweathermap.org/data/2.5/weather?q=London&appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0";

        // 2- Soruda varsa expected data olustur
        Coord coordPojo=new Coord(-0.1257f,51.5085f);
        List<Weather> weatherList= new ArrayList<>();
        Weather weatherPojo=new Weather(803,"Clouds","broken clouds","04d");
        weatherList.add(weatherPojo);

        Main mainPojo= new Main(281.55f,277.97f,280.35f,282.74f,1024,74);

        Wind windPojo= new Wind(7.2f,250,12.35f);

        Clouds cloudsPojo= new Clouds(58);

        Sys sysPojo= new Sys(2,2075535,"GB",1675237170,1675270107);

        PojoHavaDurumu expectedResponseBody=
                new PojoHavaDurumu(coordPojo,
                                    weatherList,
                                    "stations",
                                    mainPojo,
                                    10000,
                                    windPojo,
                                    cloudsPojo,
                                    1675248368,
                                    sysPojo,
                                    0,
                                    2643743,
                                    "London",
                                    200);
        // 3 - Response olustur, request gonderip sonucu response'a ata

        Response response= given().when().post(url);


        // 4- Assertion
        // expectedResponseBody Pojo  <===> response

        PojoHavaDurumu responsePojo= response.as(PojoHavaDurumu.class);
        // response'i Pojo'ya cevirdigimizde tum bilgileri getirirse
        // responsePojo'yu assertion'da kullanabiliriz
        // Eger null deger donerse, response'i JsonPath yapip assertion'da kullanabiliriz

        /*
        pojos.pojosHavaDurumu.PojoHavaDurumu@5bb51241[
            coord=pojos.pojosHavaDurumu.Coord@7479b626[lon=-0.1257,lat=51.5085],
            weather=[pojos.pojosHavaDurumu.Weather@74dbb1ee[id=803,main=Clouds,description=broken clouds,icon=04d]],
            base=stations,
            main=pojos.pojosHavaDurumu.Main@70f822e[temp=282.09,feelsLike=<null>,tempMin=<null>,tempMax=<null>,
            pressure=1024,humidity=72],visibility=10000,wind=pojos.pojosHavaDurumu.Wind@3efedc6f[speed=8.23,deg=250,gust=<null>],
            clouds=pojos.pojosHavaDurumu.Clouds@45bf6f39[all=58],dt=1675250181,
            sys=pojos.pojosHavaDurumu.Sys@6c42f2a1[type=2,id=2075535,country=GB,sunrise=1675237170,sunset=1675270107],
            timezone=0,
            id=2643743,
            name=London,
            cod=200]
         */

        JsonPath responseJP= response.jsonPath();
        // expectedResponseBody Pojo  <===> responseJP

        assertEquals(expectedResponseBody.getCoord().getLon(),
                            responseJP.get("coord.lon"));

        assertEquals(expectedResponseBody.getCoord().getLat(),
                            responseJP.get("coord.lat"));

        assertEquals(expectedResponseBody.getBase(),
                            responseJP.get("base"));

        assertEquals(expectedResponseBody.getSys().getCountry(),
                            responseJP.get("sys.country"));

        assertEquals(expectedResponseBody.getName(),
                            responseJP.get("name"));

    }
}
