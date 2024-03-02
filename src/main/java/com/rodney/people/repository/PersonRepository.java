package com.rodney.people.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodney.people.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
     
}
