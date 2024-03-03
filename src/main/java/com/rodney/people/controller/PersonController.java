package com.rodney.people.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.rodney.people.dto.request.PersonRequestDto;
import com.rodney.people.dto.response.PersonResponseDto;
import com.rodney.people.sevices.PersonServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/people")
@RequiredArgsConstructor

public class PersonController {
    private final PersonServices personServices;

    @GetMapping(value = "/{id}")
    public  ResponseEntity<PersonResponseDto> findById(@PathVariable(name="id") Long id){
        return ResponseEntity.ok().body(personServices.findById(id));
    }

    @GetMapping
    public  ResponseEntity<List<PersonResponseDto>> findAll(){
        return ResponseEntity.ok().body(personServices.findAll());
    }
    @PostMapping
    public ResponseEntity<PersonResponseDto> register(@RequestBody PersonRequestDto personRequestDto, UriComponentsBuilder uriBuilder){
        PersonResponseDto personResponseDto = personServices.register(personRequestDto);
        
        URI uri = uriBuilder.path("/people/{id}").buildAndExpand(personResponseDto.getId()).toUri();

        return ResponseEntity.created(uri).body(personResponseDto);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PersonResponseDto> update(@RequestBody PersonRequestDto personDto, @PathVariable(name="id") Long id ){
        return ResponseEntity.ok().body(personServices.update(id, personDto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(name="id") Long id ){
        return ResponseEntity.ok().body(personServices.delete(id));
    }
    


    
}
