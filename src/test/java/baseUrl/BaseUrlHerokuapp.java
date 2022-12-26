package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlHerokuapp {


    protected RequestSpecification specHerokuapp;

    @Before
    public void setUp(){

        specHerokuapp= new RequestSpecBuilder()
                                .setBaseUri("https://restful-booker.herokuapp.com")
                                .build();
    }
}
