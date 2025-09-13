package com.almada.people.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.almada.people.dto.request.PersonRequestDto;
import com.almada.people.dto.response.PersonResponseDto;
import com.almada.people.entity.Person;

@Component
public class PersonMapper {
	
	// Converts a PersonRequestDto to a Person entity
	public Person toPerson(PersonRequestDto personDto) {
		return Person.builder()
				.name(personDto.getName())
				.cpf(personDto.getCpf())
				.age(personDto.getAge())
				.build(); //
	}
	
	// Converts a Person entity to a PersonResponseDto
	public PersonResponseDto toPersonResponseDto(Person person) {
		return new PersonResponseDto(person);
	}
	
	
	
	// Converts a list of Person entities to a list of PersonResponseDto
	public List<PersonResponseDto> toPersonDto(List<Person> personList) {
		return personList.stream()
				.map(PersonResponseDto::new)
				.collect(Collectors.toList());
		
	}
	
	
	public void upDatePersonData(Person person, PersonRequestDto personDto) {
		person.setName(personDto.getName());
		person.setCpf(personDto.getCpf());
		person.setAge(personDto.getAge());
	}

}


