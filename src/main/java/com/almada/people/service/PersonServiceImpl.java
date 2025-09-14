package com.almada.people.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.almada.people.dto.request.PersonRequestDto;
import com.almada.people.dto.response.PersonResponseDto;
import com.almada.people.entity.Person;
import com.almada.people.repository.PersonRepository;
import com.almada.people.util.PersonMapper;

import lombok.RequiredArgsConstructor;

@Service
@Primary // Indica que essa é a implementação principal do PersonService
@RequiredArgsConstructor // Gera o construtor com os campos finais (final)
public class PersonServiceImpl implements PersonService {
	
	// Aqui você pode injetar o repositório, por exemplo:
	private final PersonRepository personRepository;
	
	// E o mapper
	// tem biblioteca que faz isso automaticamente, mas aqui vamos fazer na mão
	// por exemplo com MapStruct ou ModelMapper
	private final PersonMapper personMapper;
	
	

	@Override
	public PersonResponseDto findById(Long id) {
		
		return personMapper.toPersonResponseDto(returnPerson(id));

	}

	@Override
	public List<PersonResponseDto> findAll() {

		return personMapper.toPersonDto(personRepository.findAll()); // Retorna a lista de pessoas convertida para PersonResponseDto
	}

	@Override
	public PersonResponseDto register(PersonRequestDto personRequestDto) {
		Person person = personMapper.toPerson(personRequestDto); // Converte o DTO para a entidade
		
		return personMapper.toPersonResponseDto(personRepository.save(person)); // Converte a entidade salva de volta para DTO e retorna
	}

	@Override
	public PersonResponseDto update(Long id,PersonRequestDto personRequestDto) {
		Person person = returnPerson(id); // Busca a pessoa no banco de dados
		personMapper.upDatePersonData(person,personRequestDto); // Atualiza os dados da pessoa com os dados do DTO
		person = personRepository.save(person); // Salva a pessoa atualizada no banco de dados
		return personMapper.toPersonResponseDto(person); // Converte a entidade salva de volta para DTO e retorna
		

	}

	@Override
	public String delete(Long id) {
		
	    Optional<Person> optionalPerson= personRepository.findById(id);
     	if (optionalPerson.isPresent()) {

    		personRepository.deleteById(id); // Deleta a pessoa pelo ID	
    		return "Person id: " + id + " foi deletado"; // Retorna uma mensagem de confirmação
    		
     	} else {
     		return "Não encontrado";
     	}
		
		
	}
	
	
	private Person returnPerson(Long id) {
		return personRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Person was not found in database"));
	}
	

}
