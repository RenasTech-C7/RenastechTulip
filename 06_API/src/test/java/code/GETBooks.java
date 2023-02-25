package code;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GETBooks {
    //This is first way to provide baseURI
    String URL="https://simple-books-api.glitch.me/books";

    //This is second way to provide baseURI
    String baseURI=RestAssured.baseURI="https://simple-books-api.glitch.me";

    @Test(description = "Give a baseURI When we make GET call to /books Then Verify status code is 200 ")
    public void ValidateStatusCode(){
        //Given and When
        //Here we provided baseURI and endpoint
        Response response= RestAssured.get("/books");
        int actualStatusCode=response.getStatusCode();
        int expectedStatusCode=200;

        System.out.println(response.getBody().asString());

        //Then
        Assert.assertEquals(actualStatusCode,expectedStatusCode);
    }

    @Test(description = "Given a baseURI when we make a GET call to /books and use query param limit=2 Then verify status code")
    void userRetrieveListofTheBooksLimit2(){

        //Given
        //We are building request here so we need to provide parameters, body etc here.
        RequestSpecification request= given().queryParam("limit", 2);

        //Here we are making the API call
        Response response= request.when().get(URL);

        //Then
        response.then().assertThat().statusCode(200);

        //Print response body
        System.out.println(response.getBody().asString());

        //Get all headers
        System.out.println(response.getHeaders());

        //[{"id":1,"name":"The Russian","type":"fiction","available":true},
        // {"id":2,"name":"Just as I Am","type":"non-fiction","available":false}]

        String actualsecondBookName=response.jsonPath().getString("[1].name");
        String actualsecondBookId=response.jsonPath().getString("[1].id");
        String expectedSecondBookName="Just as I Am";
        String expectedSecondBookId="2";

        System.out.println("Second Book Id is :"+actualsecondBookId+", Second Book Name is :"+actualsecondBookName);

        //Using line below we can perform same action as above
//        given().queryParam("limit",2).when().get(URL)
//                .then().assertThat().statusCode(200);

        Assert.assertEquals(expectedSecondBookId,actualsecondBookId);
        Assert.assertEquals(expectedSecondBookName,actualsecondBookName);

    }

    @Test(description = "Given a baseURI When we make the GET call to /books and query parameters as type=fiction and limit=1 Then Verify Status Code")
    void userRetrieveListofBooksMultipleParameters(){

        //Given
        RequestSpecification request=given()
                .queryParams("type","fiction","limit",1);
        //When
        Response response=request.when().get("/books");

        //Then
        response.then().assertThat().statusCode(200);
        System.out.println(response.getBody().asString());

        String type= response.jsonPath().getString("[0].type");
        System.out.println(type);
        Assert.assertEquals(type,"fiction");

        String bookId=response.jsonPath().getString("[0].id");
        System.out.println(bookId);
        Assert.assertEquals(bookId,"1");

        String isAvailable=response.jsonPath().getString("[0].available");
        System.out.println(isAvailable);
        Assert.assertEquals(isAvailable,"true");

        String index0=response.jsonPath().getString("[0]");
        System.out.println(index0);
    }

    @Test(description = "Given a baseURI When we make the Get call to /books and query param as type=crime(doesnt exist) Then verify status code is 400")
    void userRetrieveListOfBooksNotExistingType(){
        //Given
        RequestSpecification request=given().queryParam("type","crime");

        //When
        Response response=request.when().get("/books");


        //Then
        response.then().assertThat().statusCode(400);

    }
    @Test(description = "Given a baseURI When we make GET call to /books and use query param limit220(out of limit) Then verify status code is 400")
    void userRetrieveListOfBooksOutOfLimit(){
        //Given
        RequestSpecification request=given()
                .queryParam("limit",220);

        //When
        Response response=request.when().get("/books");

        //Then
        response.then().assertThat().statusCode(400);
    }

    @Test(description = "Given a baseURI When we make the GET call to /books/:bookId Then Verify Status code and response")
    void userRetrieveSingleBookInformation(){
        String bookId="1";
        String bookIdFromUtils=utils.getABookId();
        //Given
        RequestSpecification request=given().pathParam("bookId",bookIdFromUtils);

        //When
        Response response=request.when().get("/books/{bookId}");


        //Then
        response.then().statusCode(200);
        System.out.println(response.getBody().asString());


    }
}
