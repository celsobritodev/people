package com.almada.people.service;

import java.util.List;

import com.almada.people.dto.PersonDTO;

public interface PersonService {
	
	PersonDTO findById(Long id);
	
	List<PersonDTO> findAll();
	
	String register();

}
