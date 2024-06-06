package com.almada.people.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.almada.people.dto.PersonDTO;

@Service
@Primary
public class PersonServiceImpl implements PersonService {

	@Override
	public PersonDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String register() {
		// TODO Auto-generated method stub
		return null;
	}

}
