package com.rodney.people.dto.response;

import com.rodney.people.entities.Person;
/*dados que estão voltando */
public class PersonResponseDto {
    private long id;
    
    private String name;
   
    private String cpf;

    private Integer age;

    public PersonResponseDto(Person person){
        this.id = person.getId();
        this.name = person.getName();
        this.cpf = person.getCpf();
        this.age = person.getAge();


    }

}
