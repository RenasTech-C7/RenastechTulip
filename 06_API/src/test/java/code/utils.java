package code;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class utils {

    public static String getABookId(){
        Response response= RestAssured.get("/books");

        response.then().assertThat().statusCode(200);

        String bookId=response.jsonPath().getString("[0].id");

        return bookId;
    }

    public static String generateBearerToken(){

        Faker faker=new Faker();
        //We generated client name and client email address here so that we can use it in request body
        String clientName=faker.name().fullName();
        String clientEmail=faker.internet().emailAddress();

        JSONObject json=new JSONObject();
        json.put("clientName",clientName);
        json.put("clientEmail",clientEmail);

        String requestPayload=json.toString();


        //Given
        //We need to provide 3 things: requestBody, Headers and any params(path or query)
        RequestSpecification generateTokenRequest=given().header("Content-Type","application/json")
                .body(requestPayload);

        //When
        Response generateTokenResponse=generateTokenRequest.when().post("/api-clients");

        System.out.println(generateTokenResponse.getBody().asString());
        generateTokenResponse.then().assertThat().statusCode(201);


        return "Bearer "+generateTokenResponse.jsonPath().getString("accessToken");


    }



}
