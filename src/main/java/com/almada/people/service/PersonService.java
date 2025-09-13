package com.almada.people.service;

import java.util.List;

import com.almada.people.dto.request.PersonRequestDto;
import com.almada.people.dto.response.PersonResponseDto;

public interface PersonService {
	
	PersonResponseDto findById(Long id);
	
	List<PersonResponseDto> findAll();
	
	PersonResponseDto register(PersonRequestDto personDto);
	
	PersonResponseDto update(Long id,PersonRequestDto personDto);
	
	String delete(Long id);

}
