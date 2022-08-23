package simple.software.learn;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

class CatTest {

  ObjectMapper mapper = new ObjectMapper();

  @Test
  void catToJson() throws JsonProcessingException {
    final Cat cat = new Cat("Monica");

    final String json = mapper.writeValueAsString(cat);

    System.out.println(json);
  }
}