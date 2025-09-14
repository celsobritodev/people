package com.almada.people.dto.controller;

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

import com.almada.people.dto.request.PersonRequestDto;
import com.almada.people.dto.response.PersonResponseDto;
import com.almada.people.service.PersonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {
	
	private final PersonService personService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<PersonResponseDto> findById(@PathVariable(name="id") Long id) {
		return ResponseEntity.ok().body(personService.findById(id)); 
	}
	
	@GetMapping
	public ResponseEntity<List<PersonResponseDto>> findAll() {
		return ResponseEntity.ok().body(personService.findAll());
	}
	
	
	@PostMapping
	public ResponseEntity<PersonResponseDto> register(@RequestBody PersonRequestDto personRequestDto,
			UriComponentsBuilder uriComponentsBuilder) {
		
		PersonResponseDto personResponseDto = personService.register(personRequestDto);
		URI uri = uriComponentsBuilder.path("/people/{id}").buildAndExpand(personResponseDto.getId()).toUri();
		return ResponseEntity.created(uri).body(personResponseDto);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PersonResponseDto> update(@PathVariable(name="id") Long id,
			@RequestBody PersonRequestDto personRequestDto) {
		
		return ResponseEntity.ok().body(personService.update(id, personRequestDto));
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable(name="id") Long id) {
       
		return ResponseEntity.ok().body(personService.delete(id));
	}
	
	
	

}
