package com.rodney.people.util;

import java.util.List;
import com.rodney.people.dto.request.PersonRequestDto;
import com.rodney.people.dto.response.PersonResponseDto;
import com.rodney.people.entities.Person;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
/* classe com metodos para mudança de dto pra person */
public class PersonMapper {
    public Person toPerson(PersonRequestDto personDto){
        return Person.builder()
        .name(personDto.getName())
        .cpf(personDto.getCpf())
        .age(personDto.getAge())
        .build();
    }
    public PersonResponseDto toPersonDto(Person person){
        return new PersonResponseDto(person);
    }
    public List<PersonResponseDto> toPeopleDTO(List<Person> peopleList){
        return peopleList.stream().map(PersonResponseDto::new).collect(Collectors.toList());
    }
    public void updatePersonData(Person person, PersonRequestDto personDto){
        person.setName(personDto.getName());
        person.setCpf(personDto.getCpf());
        person.setAge(personDto.getAge());
    }
}
