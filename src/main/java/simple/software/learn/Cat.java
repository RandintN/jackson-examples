package simple.software.learn;


import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Cat {

  private String name;

  @JsonGetter("catName")
  public String getName() {
    return name;
  }
}
