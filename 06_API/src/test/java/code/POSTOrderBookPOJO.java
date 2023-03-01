package code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class POSTOrderBookPOJO {
    //String baseURI= RestAssured.baseURI="https://simple-books-api.glitch.me";

    @BeforeClass
    public void setup(){
        //We are setting baseURI here once. It will be applied to all of the test cases in this class
        RestAssured.baseURI="https://simple-books-api.glitch.me";
    }
    @Test(description = "Given a baseURI and token When user wants to POST to /orders Then Verify Status code is 201")
    void orderBook() {

        //Order Book Call
        //Needed information: request payload, token, endpoint and header(content-type)

        //Given
        // Get a Token
        String token = utils.generateBearerToken();

        //Create Payload for the request
        Faker faker = new Faker();
        String customerName = faker.name().fullName();
        String bookId = utils.getABookId();

        JSONObject object = new JSONObject();
        object.put("bookId", bookId);
        object.put("customerName", customerName);

        String requestPayload = object.toString();

        RequestSpecification orderBookRequest = given()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .body(requestPayload);
        //When
        Response orderBookResponse = orderBookRequest.when().post("/orders");

        //Then
        orderBookResponse.then().assertThat().statusCode(201);
        System.out.println("Order Book Response Payload :" + orderBookResponse.getBody().asString());

        String orderId = orderBookResponse.jsonPath().getString("orderId");

    }

    @Test(description = "Given a baseURI and Authorization token and headers When the user wants to Order a book Then Verify if status code is 201")
    void orderBookUsingPOJO() throws JsonProcessingException {
        //Given
        // HTTP Method(POST), body, token, endpoints, headers

        //Token Generate
        String authorizationToken=utils.generateBearerToken();

        //Request payload - bookId, customerName
        Faker faker=new Faker();
        String customerName=faker.name().fullName();
        String bookId=utils.getABookId();

        //Create pojo class, set values however you like
        orderBookPOJO requestBody=new orderBookPOJO(bookId,customerName);

        //Lets convert JAVA object(requestBody) into JSON object as string(serialization)
        ObjectMapper  objectMapper=new ObjectMapper();

        //In this step, we created JSON object out of requestBody and saved as a string so that we can use it with OrderBook call
        String orderJSONPayload=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestBody);
        System.out.println("orderPayload : "+orderJSONPayload);

        RequestSpecification orderBookRequest=given()
                .header("Content-Type","application/json")
                .header("Authorization", authorizationToken)
                .body(orderJSONPayload);
        //When
        Response orderBookResponsePayload=orderBookRequest.when().post("/orders");

        //Then
        orderBookResponsePayload.then().assertThat().statusCode(201);

        String orderId=orderBookResponsePayload.jsonPath().getString("orderId");
        System.out.println(orderId);

        //UPDATE ORDER

        //Create a new customer name
        String newName="Nelly";

        //
        orderBookPOJO  orderBookPOJO=new orderBookPOJO(newName);

        ObjectMapper objectMapper1=new ObjectMapper();

        String updateOrderJSON=objectMapper1.writerWithDefaultPrettyPrinter().writeValueAsString(orderBookPOJO);

        RequestSpecification updateBookRequest=given()
                .header("Content-Type","application/json")
                .header("Authorization",authorizationToken)
                .pathParam("orderId",orderId)
                .body(updateOrderJSON);


        Response updateOrderResponse=updateBookRequest.when().patch("/orders/{orderId}");


        updateOrderResponse.then().assertThat().statusCode(204);


        RequestSpecification listofOrdersRequest= given()
                .header("Authorization",authorizationToken);

        Response listofOrdersResponse=listofOrdersRequest.when().get("/orders");
        listofOrdersResponse.then().assertThat().statusCode(200);

        System.out.println(listofOrdersResponse.getBody().asString());

        String actualNewCustomerName=listofOrdersResponse.jsonPath().getString("customerName");
        Assert.assertTrue(actualNewCustomerName.contains(newName));

    }





}
