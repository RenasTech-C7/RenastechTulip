package code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Deserialization {
    public static void main(String[] args) throws JsonProcessingException {

//        {
//            "bookId" : "1",
//            "customerName" : "Yaseen"
//        }

        String jsonObject="        {\n" +
                "            \"bookId\" : \"1\",\n" +
                "            \"customerName\" : \"Yaseen\"\n" +
                "        }";

        //Create an object of ObjectMapper class
        ObjectMapper objectMapper=new ObjectMapper();

        //Deserialize
        serializationAndDeserialization deserialization=objectMapper.readValue(jsonObject, serializationAndDeserialization.class);

        //once we get deserialization object, we can use it to access any value present in JSON object
        System.out.println("bookId is :"+deserialization.getBookId());
        System.out.println("customerName is :"+deserialization.getCustomerName());

        Map<String, Object> orderAsMap=objectMapper.readValue(jsonObject,Map.class);
        System.out.println(orderAsMap);

        //We can use map object to access values
        System.out.println("bookId is :"+orderAsMap.get("bookId"));
        System.out.println("customerName is :"+orderAsMap.get("customerName"));


    }
}
