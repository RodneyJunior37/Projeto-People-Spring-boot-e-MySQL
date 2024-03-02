package com.rodney.people.sevices;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.rodney.people.dto.request.PersonRequestDto;
import com.rodney.people.dto.response.PersonResponseDto;
import com.rodney.people.entities.Person;
import com.rodney.people.repository.PersonRepository;
import com.rodney.people.util.PersonMapper;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonServices {

    private final PersonRepository personRepository;
    
    private final PersonMapper personMapper;
    @Override
    public PersonResponseDto findById(Long id) {
        return personMapper.toPersonDto(returnPerson(id));
    }
    
    @Override
    public List<PersonResponseDto> findAll() {
        return personMapper.toPeopleDTO(personRepository.findAll());

    }
    @Override
    public PersonResponseDto register(PersonRequestDto personDto) {
        Person person = personMapper.toPerson(personDto);
        return personMapper.toPersonDto(personRepository.save(person));
    }

    @Override
    public PersonResponseDto update(PersonRequestDto personDTO, Long id) {
        Person person = returnPerson(id);

        personMapper.updatePersonData(person, personDTO);

        person = personRepository.save(person);
        return personMapper.toPersonDto(personRepository.save(person));
    }
    @Override
    public String delete(Long id) {
        personRepository.deleteById(id);
        return "Person id: "+id+"deleted";
    }
    private Person returnPerson(Long id){
        return personRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Person wasn't fount on database"));
    }
    
}
