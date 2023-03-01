package code;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class POSTOrderBook {

  //  String baseURI= RestAssured.baseURI="https://simple-books-api.glitch.me";
    @BeforeClass
    public void setup(){
        //We are setting baseURI here once. It will be applied to all of the test cases in this class
        RestAssured.baseURI="https://simple-books-api.glitch.me";
    }

    @Test(description = "Given a baseURI and token When user wants to POST to /orders Then Verify Status code is 201")
    void orderBook(){

        //Order Book Call
        //Needed information: request payload, token, endpoint and header(content-type)

        //Given
        // Get a Token
        String token=utils.generateBearerToken();

        //Create Payload for the request
        Faker faker=new Faker();
        String customerName=faker.name().fullName();
        String bookId=utils.getABookId();

        JSONObject object=new JSONObject();
        object.put("bookId",bookId);
        object.put("customerName", customerName);

        String requestPayload=object.toString();

        RequestSpecification orderBookRequest= given()
                .header("Content-Type","application/json")
                .header("Authorization", token)
                .body(requestPayload);
        //When
        Response orderBookResponse=orderBookRequest.when().post("/orders");

        //Then
        orderBookResponse.then().assertThat().statusCode(201);
        System.out.println("Order Book Response Payload :"+orderBookResponse.getBody().asString());

        String orderId=orderBookResponse.jsonPath().getString("orderId");

        //RETRIEVE ORDER(S)
        //Lets Make the Second call : List of Ordered Book(s)

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

        //UPDATE ORDER - Patch
        // Token, Content-Type, path param, requestBody

        String newCustomerName="Onder";

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

        //MAKE ANOTHER CALL TO : List of the Ordered Book(s)
        listOfOrdersRequest=given()
                .header("Authorization",token);
        listOfOrdersResponse=listOfOrdersRequest.when().get("/orders");

        listOfOrdersResponse.then().assertThat().statusCode(200);

        System.out.println(listOfOrdersResponse.getBody().asString());

        String actualNewCustomerName=listOfOrdersResponse.jsonPath().getString("customerName");

        Assert.assertTrue(actualNewCustomerName.contains(newCustomerName));

        //DELETE ORDER

        //Given
        // Token, path params, Content-Type Delete(HTTP) Body(if required)

        RequestSpecification deleteOrderRequest=given()
                .pathParam("orderId",orderId)
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .body("{}");
        //When
        Response deleteOrderResponse=deleteOrderRequest.when().delete("/orders/{orderId}");

        //Then
        deleteOrderResponse.then().assertThat().statusCode(204);



        //LAST CALL TO VERIFY IF IT GOT DELETED - List of the Ordered Books
        listOfOrdersRequest=given()
                .header("Authorization",token);
        listOfOrdersResponse=listOfOrdersRequest.when().get("/orders");
        listOfOrdersResponse.then().assertThat().statusCode(200);

        System.out.println(listOfOrdersResponse.getBody().asString());
        String listOftheOrdersResponseBody=listOfOrdersResponse.getBody().asString();
        Assert.assertTrue(!listOftheOrdersResponseBody.contains(orderId));
    }



}
