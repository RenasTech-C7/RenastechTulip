package code;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public static String readFile(String path) {
        //In this method we are reading file from the path given and converting the file to String and returning the data
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void retrieveMyOrder(String token, String customerName){
        //Given
        RequestSpecification listOfOrdersRequest=given()
                .header("Authorization",token);

        //When
        Response listOfOrdersResponse=listOfOrdersRequest.when().get("/orders");

        //Then
        listOfOrdersResponse.then().assertThat().statusCode(200);
        System.out.println(listOfOrdersResponse.getBody().asString());

        String actualCustomerName=listOfOrdersResponse.jsonPath().getString("customerName");
        Assert.assertTrue(actualCustomerName.contains(customerName));
    }

    public static void updateMyOrder(String newCustomerName, String orderId, String token){


        JSONObject objectNewName=new JSONObject();
        objectNewName.put("customerName",newCustomerName);
        String updateOrderRequestPayload=objectNewName.toString();

        //Given
        RequestSpecification updateOrderRequest=given()
                .pathParam("orderId",orderId)
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .body(updateOrderRequestPayload);

        //When
        Response updateOrderResponse=updateOrderRequest.when().patch("/orders/{orderId}");

        updateOrderResponse.then().assertThat().statusCode(204);



    }



}
