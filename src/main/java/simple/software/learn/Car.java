package simple.software.learn;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;

@Getter
public class Car {
  @JsonSetter("carBrand")
  private String brand;
}
