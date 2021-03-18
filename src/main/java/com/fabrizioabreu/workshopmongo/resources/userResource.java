package com.fabrizioabreu.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabrizioabreu.workshopmongo.domain.User;
import com.fabrizioabreu.workshopmongo.dto.UserDTO;
import com.fabrizioabreu.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class userResource {

	@Autowired
	private UserService service;
	
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findaAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	// Retornar usuário por ID
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<UserDTO> findById(@PathVariable String id){
			User obj = service.findById(id);
			return ResponseEntity.ok().body(new UserDTO(obj));
		}
}
