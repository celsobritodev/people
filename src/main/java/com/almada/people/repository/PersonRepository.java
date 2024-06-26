package com.almada.people.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.almada.people.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

}
