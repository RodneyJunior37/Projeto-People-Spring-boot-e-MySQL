package com.rodney.people.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    private ResponseEntity<PersonResponseDto> findById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok().body(personServices.findById(id));
    }

    @GetMapping
    private ResponseEntity<List<PersonResponseDto>> findAll(){
        return ResponseEntity.ok().body(personServices.findAll());
    }
    @PostMapping
    private ResponseEntity<PersonResponseDto> register(@ResponseBody PersonRequestDto personDto,UriComponentsBuilder uriBuilder){
        pers
        URI uri = uriBuilder.path("/people/{id}").buildAndExpand(personServices.register(personDto)).toUri();
        return ResponseEntity.created(uri).body(personServices.register(personDto));
    }
    
}
