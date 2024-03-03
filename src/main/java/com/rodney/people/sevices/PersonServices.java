package com.rodney.people.sevices;

import java.util.List;

import com.rodney.people.dto.request.PersonRequestDto;
import com.rodney.people.dto.response.PersonResponseDto;

public interface PersonServices {
    PersonResponseDto findById(Long id);

    List<PersonResponseDto> findAll();

    PersonResponseDto register(PersonRequestDto personDto);

    PersonResponseDto update(Long id, PersonRequestDto personDTO );

    String delete(Long id);
}
