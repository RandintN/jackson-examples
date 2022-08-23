package simple.software.learn;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class PersonDTO {

  private String id;
  private String firstName;
  private String lastName;

  public static void main(String[] args) {
    final BasicUser user = BasicUser.builder()
        .id(444)
        .name("Robson Cassiano")
        .build();
    final PersonDTO personDTO = BasicMapper.INSTANCE.convertCustom(user);

    System.out.println(personDTO.getFirstName());
    System.out.println(personDTO.getLastName());
  }
}
