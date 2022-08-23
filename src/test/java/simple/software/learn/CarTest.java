package simple.software.learn;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class CarTest {

  ObjectMapper mapper = new ObjectMapper();

  @Test
  void getBrand() throws IOException {
    final String json = """
        {
          "carBrand" : "BMW"
        }
        """;
    final Car car = mapper.readValue(json, Car.class);

    assertEquals("BMW", car.getBrand());
  }
}