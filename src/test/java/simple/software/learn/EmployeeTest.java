package simple.software.learn;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmployeeTest {

  ObjectMapper objectMapper = new ObjectMapper();


  @Test
  void pojoToJsonString() throws JsonProcessingException {
    final Employee employee = new Employee("Mark", "James", 20);

    final String json = objectMapper.writeValueAsString(employee);

    System.out.println(json);
  }

  @Test
  void jsonStringToPojo() throws JsonProcessingException {
    //language=JSON
    String employeeJson = "{\"firstName\": \"Robson\", \"lastName\": \"Cassiano\", \"age\": 30}";

    final Employee employee = objectMapper.readValue(employeeJson, Employee.class);

    final String actualFirstName = employee.getFirstName();
    assertEquals("Robson", actualFirstName);
  }

  @Test
  void jsonFileToPojo() throws IOException {
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    final File file = new File("src/test/resources/employee.json");
    final Employee employee = objectMapper.readValue(file, Employee.class);

    final String actualFirstName = employee.getFirstName();
    final Integer actualAge = employee.getAge();
    final String actualLastName = employee.getLastName();

    assertEquals(44, actualAge);
    assertEquals("Homer", actualFirstName);
    assertEquals("Simpson", actualLastName);
  }

  @Test
  void byteArrayToPojo() throws IOException {
    String employeeJson = """
        {
         "firstName" : "Robson",
         "lastName" : "Cassiano",
         "age" : 32
        }
        """;

    final Employee employee = objectMapper.readValue(employeeJson.getBytes(), Employee.class);

    final String actualFirstName = employee.getFirstName();
    assertEquals("Robson", actualFirstName);
  }

  @Test
  void fileToListOfPojos() throws IOException {
    final File file = new File("src/test/resources/employeesList.json");
    final List<Employee> employeeList = objectMapper.readValue(file, new TypeReference<>(){});

    assertEquals(2, employeeList.size());
    employeeList.forEach(employee -> System.out.println(employee.getFirstName()));
  }

}