package com.rodney.people.dto.request;

import lombok.Getter;
/*dados que a pessoa esta enviando do cliente pra api*/
@Getter
public class PersonRequestDto {
    
    
    private String name;
   
    private String cpf;

    private Integer age;
}
