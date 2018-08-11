package rikkeisoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rikkeisoft.constants.CrudStatus;
import rikkeisoft.domain.User;
import rikkeisoft.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> findAllOrderByName() {
		List<User> l_lisUser = userService.findAllOrderByName();
		return new ResponseEntity<List<User>>(l_lisUser, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> finById(@PathVariable("id") Integer id){
		User l_user = userService.findById(id);
		if (l_user == null)
		{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> insert (@RequestBody User user){
		int l_status = userService.insert(user);
		if(l_status == CrudStatus.SUCCESS)
		{
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") Integer id , @RequestBody User user){
		int l_status = userService.update(user);
		if (l_status == CrudStatus.SUCCESS)
		{
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		int l_status = userService.deleteById(id);
		if(l_status == CrudStatus.SUCCESS) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
