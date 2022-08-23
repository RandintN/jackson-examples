package simple.software.learn;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BasicMapper {

  BasicMapper INSTANCE = Mappers.getMapper(BasicMapper.class);
  BasicUserDTO convert(BasicUser user);

  default PersonDTO convertCustom(BasicUser user) {
    return PersonDTO
        .builder()
        .id(String.valueOf(user.getId()))
        .firstName(user.getName().substring(0, user.getName().indexOf(" ")))
        .lastName(user.getName().substring(user.getName().indexOf(" ") + 1))
        .build();
  }

}
