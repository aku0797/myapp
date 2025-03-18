package apiautomationpractise;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.PetCategoryPojo;
import pojo.PetsPojo;

import java.io.File;
import java.io.IOException;

public class SerializationTest {

    @Test
    public void serializationPractice() throws IOException {
        PetsPojo petsPojo=new PetsPojo();
        petsPojo.setName("Rex");
        petsPojo.setStatus("running out");
        petsPojo.setId(989);
        PetCategoryPojo petCategoryPojo=new PetCategoryPojo();
        petCategoryPojo.setName("Alabay");
        petCategoryPojo.setId(23);
        ObjectMapper objectMapper=new ObjectMapper(); //serialization
        File file=new File("src/test/resources/pet.json");
        objectMapper.writeValue(file, petsPojo);
    }
}
