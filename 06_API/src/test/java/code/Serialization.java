package code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serialization {
    public static void main(String[] args) throws JsonProcessingException {
     //Step 1 - Create an object of POJO class and set required values

        serializationAndDeserialization serialization=new serializationAndDeserialization();
        serialization.setBookId("1");
        serialization.setCustomerName("Benjamin");

        //ObjectMAPPER class to serialize POJO object to JSON
        //Create an object of ObjectMAPPER using Jackson dependancy
        ObjectMapper objectMapper=new ObjectMapper();

        String jsonPayload=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(serialization);
        System.out.println("JSON object we created >>> "+jsonPayload);


    }
}
